package dao;

/**
 * Created by Shraddha on 22-07-2017.
 */
public class User {
    private long id;
    private String name;
    private String email;
    private String encodedpwd;
    private String createdAt;
    private  String updatedAt;

    public User(long id, String name, String email, String encodedpwd, String createdAt, String updatedAt) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.encodedpwd = encodedpwd;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public String getEncodedpwd() {
        return encodedpwd;
    }
}
