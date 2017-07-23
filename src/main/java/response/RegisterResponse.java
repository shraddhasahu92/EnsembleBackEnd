package response;

import dao.User;

/**
 * Created by Shraddha on 23-07-2017.
 */
public class RegisterResponse {
    Boolean error;
    String error_msg;
    Long uid;
    User user;


    public RegisterResponse(Boolean error, String error_msg,Long uid, User user) {
        this.error = error;
        this.error_msg = error_msg;
        this.uid = uid;
        this.user = user;
    }

    public Boolean getError() {
        return error;
    }

    public String getError_msg() {
        return error_msg;
    }

    public User getUser() {
        return user;
    }

    public Long getUid() {
        return uid;
    }
}


