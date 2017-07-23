package App;

import db.DbFunctions;
import org.springframework.web.bind.annotation.*;
import response.LoginResponse;

/**
 * Created by Shraddha on 21-07-2017.
 */

@RestController
public class LoginController {

    @RequestMapping("/login")
    public LoginResponse login(@RequestParam(value = "email", defaultValue = "user@example.com")
            String email, @RequestParam(value = "password",defaultValue = "1234") String password){

        System.out.println(" Login Request received!!!!!!!!!");


        return DbFunctions.authenticateUser(email, password);
    }


}
