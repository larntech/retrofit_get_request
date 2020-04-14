package net.larntech.retrofit.model.response;

import java.io.Serializable;

public class UserResponse implements Serializable {


    /**
     * id : 5
     * url : http://api.larntech.net/users/5/
     * username : larntech
     * first_name : larn
     * last_name : tech
     * email : richard@larntech.net
     * is_active : true
     * date_joined : 2020-04-14 06:44:06
     * last_login : null
     */

    private int id;
    private String url;
    private String username;
    private String first_name;
    private String last_name;
    private String email;
    private boolean is_active;
    private String date_joined;
    private Object last_login;

    @Override
    public String toString() {
        return "UserResponse{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", is_active=" + is_active +
                ", date_joined='" + date_joined + '\'' +
                ", last_login=" + last_login +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isIs_active() {
        return is_active;
    }

    public void setIs_active(boolean is_active) {
        this.is_active = is_active;
    }

    public String getDate_joined() {
        return date_joined;
    }

    public void setDate_joined(String date_joined) {
        this.date_joined = date_joined;
    }

    public Object getLast_login() {
        return last_login;
    }

    public void setLast_login(Object last_login) {
        this.last_login = last_login;
    }
}
