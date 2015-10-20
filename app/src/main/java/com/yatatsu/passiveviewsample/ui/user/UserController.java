package com.yatatsu.passiveviewsample.ui.user;

import com.yatatsu.passiveviewsample.data.api.GitHubService;
import com.yatatsu.passiveviewsample.data.model.User;
import com.yatatsu.passiveviewsample.ui.base.Controller;

import rx.functions.Action1;


public class UserController extends Controller<UserScreen> {

    private final GitHubService gitHubService;
    private String username;

    public UserController(GitHubService gitHubService) {
        this.gitHubService = gitHubService;
    }

    void onCreateScreen(String username) {
        this.username = username;
        register(gitHubService.getUser(username)
                .subscribe(
                        new Action1<User>() {
                            @Override
                            public void call(User user) {
                                getScreen().showUserImage(user.avatarUrl);
                                getScreen().showUserName(user.name);
                            }
                        }, new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                throwable.printStackTrace();
                                getScreen().showErrorDialog(throwable.getMessage());
                            }
                        }));
    }

    void onClickReposButton() {
        getScreen().navigateToReposScreen(username);
    }

    void onDestroyScreen() {
        unSubscribe();
    }
}
