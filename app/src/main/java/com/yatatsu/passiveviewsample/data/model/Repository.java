package com.yatatsu.passiveviewsample.data.model;


public class Repository {
    public String name;
    public String fullName;
    public String description;
    public String htmlUrl;
    public int stargazersCount;
    public int watchersCount;

    public Repository(String name,
                      String fullName,
                      String description,
                      String htmlUrl,
                      int stargazersCount,
                      int watchersCount) {
        this.name = name;
        this.fullName = fullName;
        this.description = description;
        this.htmlUrl = htmlUrl;
        this.stargazersCount = stargazersCount;
        this.watchersCount = watchersCount;
    }

    public Repository() {

    }


}
