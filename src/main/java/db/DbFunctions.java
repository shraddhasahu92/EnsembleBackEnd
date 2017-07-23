package db;

import login.User;
import response.RegisterResponse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Shraddha on 21-07-2017.
 */
public class DbFunctions {

    public static RegisterResponse storeUser(String name, String email, String password ){

        RegisterResponse registerResponse;
        User user = isUserExisted(email);
        if(user != null){
            // User already exists
            registerResponse = new RegisterResponse("2","User already exists with email " + email,user.getId(),user);
            return registerResponse;
        }

        String encodedPassword = Encoder.encode(password);

        try {
            Connection conn = DbConnect.openConnection();
            String sql = "INSERT INTO users(name, email, encrypted_password, salt, created_at) VALUES( ?, ?, ?, ?, NOW())";
            PreparedStatement stmt = conn.prepareStatement(sql);



//            stmt.setLong(1,uid.incrementAndGet());
            stmt.setString(1,name);
            stmt.setString(2,email);
            stmt.setString(3,encodedPassword);
            stmt.setString(4,"salt");

            stmt.execute();
            DbConnect.closeConnection(conn);

            user = isUserExisted(email);

            //Registeration succesfull
            registerResponse = new RegisterResponse("false","",user.getId(),user);

        }catch (SQLException e){
            e.printStackTrace();

            //Error while inserting userdata
            registerResponse = new RegisterResponse("1","Unknown error occurred in registration!",0L,null);
        }
        return registerResponse;
    }

    public static User isUserExisted(String email){

        User user = null;
        try {
            Connection conn = DbConnect.openConnection();

            String sql = "SELECT * FROM users where email = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,email);


            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                Long id = rs.getLong(1);
                String name = rs.getString(2);
                String em = rs.getString(3);
                String encodedPwd = rs.getString(4);
                String createdAt = rs.getString(6);
                String updatedAt = rs.getString(7);

                user = new User(id,name,em,encodedPwd,createdAt,updatedAt);
            }
//                return true;

            DbConnect.closeConnection(conn);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }

    public static User authenticateUser(String email, String password){

        User user = isUserExisted(email);

        if(user == null) {
            System.out.println("email does not exist!");
            return null;
        }

        else if(Encoder.match(password,user.getEncodedpwd()))
        {
            System.out.println("successfully logged in!!");
        }
        else{
            System.out.println("Incorrect password!");
        }


        return user;
    }


}
