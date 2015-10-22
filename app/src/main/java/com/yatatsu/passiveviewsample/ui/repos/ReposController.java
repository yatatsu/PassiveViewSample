package com.yatatsu.passiveviewsample.ui.repos;


import com.yatatsu.passiveviewsample.data.api.GitHubService;
import com.yatatsu.passiveviewsample.data.model.Repository;
import com.yatatsu.passiveviewsample.ui.base.Controller;

import java.util.List;

import rx.functions.Action1;

public class ReposController extends Controller<ReposScreen> {

    private final GitHubService github;
    private String username;

    public ReposController(GitHubService github) {
        this.github = github;
    }

    void onCreateScreen(String username) {
        this.username = username;
    }

    void onStartScreen() {
        register(github.getRepositories(username)
                .subscribe(new Action1<List<Repository>>() {
                    @Override
                    public void call(List<Repository> repositories) {
                        getScreen().showRepositories(repositories);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                        throwable.printStackTrace();
                        getScreen().showError(throwable.getMessage());
                    }
                }));
    }

    void onStopScreen() {
        unSubscribe();
    }
}
