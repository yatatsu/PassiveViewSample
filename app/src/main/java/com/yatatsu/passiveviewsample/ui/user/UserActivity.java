package com.yatatsu.passiveviewsample.ui.user;


import android.os.Bundle;

import com.yatatsu.passiveviewsample.PVSApplication;
import com.yatatsu.passiveviewsample.dagger.component.DaggerActivityInjectorComponent;
import com.yatatsu.passiveviewsample.ui.base.ScreenActivity;

import javax.inject.Inject;

public class UserActivity extends ScreenActivity<UserController> implements UserScreen {

    @Inject
    UserController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected UserController getController() {
        DaggerActivityInjectorComponent.builder()
                .baseComponent(PVSApplication.getBaseComponent())
                .build()
                .inject(this);
        return controller;
    }
}
