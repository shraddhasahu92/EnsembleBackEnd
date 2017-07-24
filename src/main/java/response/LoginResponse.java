package response;

import dao.User;

import java.util.ArrayList;

/**
 * Created by Shraddha on 23-07-2017.
 */


public class LoginResponse {

    Boolean error;
    String error_msg;
    Long uid;
    String success;
    String tag;
    ArrayList<User> users;


    public LoginResponse(Boolean error, String error_msg, Long uid, String success, String tag, ArrayList<User> users  ) {
        this.error = error;
        this.error_msg = error_msg;
        this.uid = uid;
        this.success = success;
        this.tag = tag;
        this.users = users;
    }

    public Boolean getError() {
        return error;
    }

    public String getError_msg() {
        return error_msg;
    }

    public Long getUid() {
        return uid;
    }

    public String getSuccess() {
        return success;
    }

    public String getTag() {
        return tag;
    }

    public ArrayList<User>  getUsers() {
        return users;
    }
}
