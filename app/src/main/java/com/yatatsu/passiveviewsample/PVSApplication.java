package com.yatatsu.passiveviewsample;

import android.app.Application;
import android.content.Context;

import com.yatatsu.passiveviewsample.dagger.AppComponent;
import com.yatatsu.passiveviewsample.dagger.AppModule;
import com.yatatsu.passiveviewsample.dagger.DaggerAppComponent;


public class PVSApplication extends Application {

    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

    public static AppComponent getAppComponent() {
        return appComponent;
    }

    public static Context getAppContext() {
        return appComponent.getApplicationContext();
    }
}