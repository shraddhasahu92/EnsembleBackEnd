package response;

import login.User;

/**
 * Created by Shraddha on 23-07-2017.
 */
public class LoginResponse {

    String error;
    String error_msg;
    String uid;
    String success;
    String tag;
    User user;


    public LoginResponse(String error, String error_msg, String uid, String success, String tag, User user) {
        this.error = error;
        this.error_msg = error_msg;
        this.uid = uid;
        this.success = success;
        this.tag = tag;
        this.user = user;
    }

    public String getError() {
        return error;
    }

    public String getError_msg() {
        return error_msg;
    }

    public String getUid() {
        return uid;
    }

    public String getSuccess() {
        return success;
    }

    public String getTag() {
        return tag;
    }

    public User getUser() {
        return user;
    }
}
