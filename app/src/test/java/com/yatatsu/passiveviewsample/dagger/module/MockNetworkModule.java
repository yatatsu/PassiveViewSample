package com.yatatsu.passiveviewsample.dagger.module;


import android.content.Context;

import com.squareup.okhttp.OkHttpClient;

public class MockNetworkModule extends NetworkModule {

    @Override
    public OkHttpClient provideOkHttpClient(Context context) {
        return new OkHttpClient();
    }
}