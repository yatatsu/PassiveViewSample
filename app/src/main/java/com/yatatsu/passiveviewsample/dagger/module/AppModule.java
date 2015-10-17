package com.yatatsu.passiveviewsample.dagger.module;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private Context applicationContext;

    public AppModule(Application application) {
        applicationContext = application;
    }

    @Singleton
    @Provides
    public Context provideApplicationContext() {
        return applicationContext;
    }
}
