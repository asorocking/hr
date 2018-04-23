package com.asorokin.model;

import java.util.ArrayList;
import java.util.List;


public class User {
    
    private int id;
    private String login;
    private String password;
    public static List<User> users = new ArrayList<User>();
    public static int userID = 1;
    

    public User() {

    }

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public User(int id, String login, String password) {
        this.id = id;
        this.login = login;
        this.password = password;
    }

    public int getID() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }
}
