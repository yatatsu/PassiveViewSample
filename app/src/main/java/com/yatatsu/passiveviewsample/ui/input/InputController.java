package com.yatatsu.passiveviewsample.ui.input;


import com.yatatsu.passiveviewsample.ui.base.Controller;

public class InputController extends Controller<InputScreen> {

    void onSubmitEditText(String input) {
        if (input == null || input.isEmpty()) {
            getScreen().showError("input must not be empty.");
            return;
        }
        input = input.trim();
        if (input.contains(" ")) {
            getScreen().showError("should be one word.");
        } else {
            getScreen().hideError();
            getScreen().navigateToUserScreen(input);
        }
    }
}
