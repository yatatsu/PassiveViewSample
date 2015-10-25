package com.yatatsu.passiveviewsample.data.api;

import com.yatatsu.passiveviewsample.data.model.Repository;
import com.yatatsu.passiveviewsample.data.model.User;

import java.util.ArrayList;
import java.util.List;


public final class MockData {

    public static User mockUser() {
        User user = new User();
        user.login = "username";
        user.name = "FULL NAME";
        user.avatarUrl = "mock://avatar/avatar.png";
        return user;
    }

    public static List<Repository> mockRepositories() {
        List<Repository> repos = new ArrayList<>(2);
        Repository repo1 = new Repository();
        repo1.name = "repo 1";
        repo1.fullName = "repo 1 full";
        repo1.description = "repo 1 description";
        repo1.htmlUrl = "mock://html/url.html";
        repo1.stargazersCount = 10;
        repo1.watchersCount = 20;
        repos.add(repo1);
        return repos;
    }
}
