package com.yatatsu.passiveviewsample.ui.user;

import com.yatatsu.passiveviewsample.ui.base.Screen;


public interface UserScreen extends Screen {
    void showUserImage(String avatarUrl);
    void showUserName(String fullName);
    void showErrorDialog(String message);
    void navigateToReposScreen(String username);
}
