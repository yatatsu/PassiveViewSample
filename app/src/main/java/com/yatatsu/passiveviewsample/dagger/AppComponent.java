package com.yatatsu.passiveviewsample.dagger;

import android.content.Context;

import dagger.Component;

@Component(modules = {AppModule.class})
public interface AppComponent {
    Context getApplicationContext();
}
