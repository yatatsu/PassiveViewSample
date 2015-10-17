package com.yatatsu.passiveviewsample.dagger.module;

import com.squareup.okhttp.OkHttpClient;
import com.yatatsu.passiveviewsample.dagger.scope.ApplicationScope;
import com.yatatsu.passiveviewsample.data.network.GithubApi;
import com.yatatsu.passiveviewsample.data.network.GithubApiService;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;


@Module
public class GithubApiModule {

    @ApplicationScope
    @Provides
    GithubApiService provideGithubApiService(OkHttpClient okHttpClient,
                                             Scheduler scheduler) {
        return new GithubApi(okHttpClient, scheduler);
    }
}
