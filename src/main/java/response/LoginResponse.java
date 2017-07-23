package response;

import dao.User;

/**
 * Created by Shraddha on 23-07-2017.
 */


public class LoginResponse {

    Boolean error;
    String error_msg;
    Long uid;
    String success;
    String tag;
    User user;


    public LoginResponse(Boolean error, String error_msg, Long uid, String success, String tag, User user) {
        this.error = error;
        this.error_msg = error_msg;
        this.uid = uid;
        this.success = success;
        this.tag = tag;
        this.user = user;
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

    public User getUser() {
        return user;
    }
}
