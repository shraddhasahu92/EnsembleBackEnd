package db;

import com.sun.org.apache.regexp.internal.RE;
import login.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.Formatter;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Shraddha on 21-07-2017.
 */
public class DbFunctions {

    private static final AtomicLong uid = new AtomicLong();

    public static boolean storeUser(String name, String email, String password ){

        if(isUserExisted(email)){
            return false;
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

        }catch (SQLException e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean isUserExisted(String email){
        try {
            Connection conn = DbConnect.openConnection();

            String sql = "SELECT email FROM users where email = ?";

            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,email);


            ResultSet rs = stmt.executeQuery();

            if(rs.next())
                return true;

            DbConnect.closeConnection(conn);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return false;
    }

    public static User authenticateUser(String email, String password){

        if(!isUserExisted(email)) {
            System.out.println("email does not exist!");
            return null;
        }

        User user = null;

        try {
            Connection conn = DbConnect.openConnection();
            String sql = "select * from users where email = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,email);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                boolean authenticated = Encoder.match(password,rs.getString(4));
                if(authenticated) {
                    user = new User(rs.getString(2), email, password);
                    System.out.println("Successfully authenticated");
                }
                else {
                    System.out.println("Incorrect password");
                }
            }

            DbConnect.closeConnection(conn);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return user;
    }


}
