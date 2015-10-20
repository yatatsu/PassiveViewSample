package com.yatatsu.passiveviewsample.ui.base;


import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public abstract class Controller<T extends Screen> {

    private T screen;
    private CompositeSubscription compositeSubscription;

    void registerScreen(T screen) {
        this.screen = screen;
    }

    protected T getScreen() {
        return screen;
    }

    protected void register(Subscription subscription) {
        if (compositeSubscription == null) {
            compositeSubscription = new CompositeSubscription();
        }
        compositeSubscription.add(subscription);
    }

    protected void unSubscribe() {
        if (compositeSubscription != null) {
            compositeSubscription.unsubscribe();
            compositeSubscription = null;
        }
    }
}
