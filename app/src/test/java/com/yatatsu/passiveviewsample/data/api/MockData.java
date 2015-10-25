package com.yatatsu.passiveviewsample.data.api;

import com.yatatsu.passiveviewsample.data.model.Repository;
import com.yatatsu.passiveviewsample.data.model.User;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public final class MockData {

    public static final User MOCK_USER = new User("username", "FULL NAME", "mock://avatar/avatar.png");
    public static final List<Repository> MOCK_REPOS = Collections.unmodifiableList(
            new ArrayList<Repository>(1) {
                {
                    add(new Repository("repo",
                            "repo full",
                            "repo description",
                            "mock://html/url.html",
                            10,
                            20));
                }
            });
}
