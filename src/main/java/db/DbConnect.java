package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by Shraddha on 21-07-2017.
 */
public class DbConnect {
    public static Connection openConnection(){
        Connection conn = null;

        try {
            conn =  DriverManager.getConnection("jdbc:mysql://"+Config.DB_HOST+":3306/"
                            + Config.DB_DATABASE,Config.DB_USER,Config.DB_PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }

        return conn;
    }

    public static void closeConnection(Connection conn){

        try {
//            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
