package com.hashcode.booker.models;

/**
 * Created by HashCode on 10:57 AM 03/04/2018.
 */

public class LoginBody {
    private String username;
    private String password;

    public LoginBody(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
