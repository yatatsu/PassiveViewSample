package com.yatatsu.passiveviewsample.ui.repos;


import android.os.Bundle;

import com.yatatsu.passiveviewsample.PVSApplication;
import com.yatatsu.passiveviewsample.dagger.component.DaggerActivityInjectorComponent;
import com.yatatsu.passiveviewsample.ui.base.ScreenActivity;

import javax.inject.Inject;

public class ReposActivity extends ScreenActivity<ReposController> implements ReposScreen {

    @Inject
    ReposController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected ReposController getController() {
        DaggerActivityInjectorComponent.builder()
                .baseComponent(PVSApplication.getBaseComponent())
                .build()
                .inject(this);
        return controller;
    }
}
