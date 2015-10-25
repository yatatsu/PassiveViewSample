package com.yatatsu.passiveviewsample.data.model;


public class User {
    public String login;
    public String avatarUrl;
    public String name;

    public User() {

    }

    public User(String login, String name, String avatarUrl) {
        this.login = login;
        this.name = name;
        this.avatarUrl = avatarUrl;
    }
}
