package db;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by Shraddha on 22-07-2017.
 */
public class Encoder {

    private static PasswordEncoder encoder = new BCryptPasswordEncoder();

    public static String encode(String password){
        return encoder.encode(password);
    }

    public static boolean match( String password,String encodedPassword){
        return encoder.matches(password,encodedPassword);
    }
}
