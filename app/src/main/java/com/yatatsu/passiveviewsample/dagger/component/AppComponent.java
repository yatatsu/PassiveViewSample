package com.yatatsu.passiveviewsample.dagger.component;

import android.content.Context;

import com.yatatsu.passiveviewsample.dagger.module.AppModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class})
public interface AppComponent {
    Context getApplicationContext();
}
