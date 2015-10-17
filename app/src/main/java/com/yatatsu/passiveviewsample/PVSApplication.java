package com.yatatsu.passiveviewsample;

import android.app.Application;

import com.yatatsu.passiveviewsample.dagger.component.AppComponent;
import com.yatatsu.passiveviewsample.dagger.component.BaseComponent;
import com.yatatsu.passiveviewsample.dagger.component.DaggerAppComponent;
import com.yatatsu.passiveviewsample.dagger.component.DaggerBaseComponent;
import com.yatatsu.passiveviewsample.dagger.module.AppModule;


public class PVSApplication extends Application {

    private static BaseComponent baseComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
        baseComponent = DaggerBaseComponent.builder()
                .appComponent(appComponent)
                .build();
    }

    public static BaseComponent getBaseComponent() {
        return baseComponent;
    }
}