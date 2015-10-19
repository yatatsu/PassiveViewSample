package com.yatatsu.passiveviewsample.ui.input;


import com.yatatsu.passiveviewsample.ui.base.Screen;

public interface InputScreen extends Screen {
    void navigateToUserScreen(String username);
    void showError(String message);
    void hideError();
}
