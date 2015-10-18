package com.yatatsu.passiveviewsample.ui.base;


public abstract class Controller<T extends Screen> {

    private T screen;

    void registerScreen(T screen) {
        this.screen = screen;
    }

    protected T getScreen() {
        return screen;
    }
}
