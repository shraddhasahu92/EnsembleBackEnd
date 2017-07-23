package App;

import db.DbFunctions;
import org.apache.catalina.connector.Response;
import org.springframework.web.bind.annotation.*;
import response.RegisterResponse;

import java.io.PrintWriter;

/**
 * Created by Shraddha on 21-07-2017.
 */

@RestController
public class RegisterController {

    @RequestMapping("/register")
    public RegisterResponse register(@RequestParam(value = "name", defaultValue = "guest") String name, @RequestParam(value = "email", defaultValue = "user@example.com")
            String email, @RequestParam(value = "password",defaultValue = "1234") String password){

        System.out.println("Register request received!!!!!!!!!");


        return DbFunctions.storeUser(name,email,password);
    }


}
