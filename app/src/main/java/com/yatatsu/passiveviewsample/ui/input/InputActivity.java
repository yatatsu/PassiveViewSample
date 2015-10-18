package com.yatatsu.passiveviewsample.ui.input;

import android.os.Bundle;

import com.yatatsu.passiveviewsample.PVSApplication;
import com.yatatsu.passiveviewsample.dagger.component.DaggerActivityInjectorComponent;
import com.yatatsu.passiveviewsample.ui.base.ScreenActivity;

import javax.inject.Inject;


public class InputActivity extends ScreenActivity<InputController> implements InputScreen {

    @Inject
    InputController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected InputController getController() {
        DaggerActivityInjectorComponent.builder()
                .baseComponent(PVSApplication.getBaseComponent())
                .build()
                .inject(this);
        return controller;
    }
}
