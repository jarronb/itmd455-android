package com.example.bailey.journeyhome.model;

/**
 * Created by kingo on 11/26/2017.
 */


public class User {

    private int id;
    private String utype;
    private String email;
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return utype;
    }

    public void setType(String utype) {
        this.utype = utype;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}