package com.yatatsu.passiveviewsample.dagger;

import android.app.Application;
import android.content.Context;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context applicationContext;

    public AppModule(Application application) {
        applicationContext = application;
    }

    @Provides
    public Context provideApplicationContext() {
        return applicationContext;
    }
}
