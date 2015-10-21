package com.yatatsu.passiveviewsample.dagger.module;

import android.content.Context;

import com.squareup.okhttp.Cache;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.picasso.OkHttpDownloader;
import com.squareup.picasso.Picasso;
import com.yatatsu.passiveviewsample.dagger.scope.ApplicationScope;

import java.io.File;

import dagger.Module;
import dagger.Provides;

/**
 * NetworkModule
 */
@Module
public class NetworkModule {

    @ApplicationScope
    @Provides
    public OkHttpClient provideOkHttpClient(Context context) {
        File cacheFile = new File(context.getCacheDir(), "okhttp.cache");
        Cache cache = new Cache(cacheFile, 4 * 1024 * 1024);
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setCache(cache);
        return okHttpClient;
    }

    @ApplicationScope
    @Provides
    public Picasso providePicasso(Context context, OkHttpClient okHttpClient) {
        OkHttpDownloader downloader = new OkHttpDownloader(okHttpClient);
        Picasso picasso = new Picasso.Builder(context)
                .downloader(downloader)
                .build();
        Picasso.setSingletonInstance(picasso);
        return Picasso.with(context);
    }
}
