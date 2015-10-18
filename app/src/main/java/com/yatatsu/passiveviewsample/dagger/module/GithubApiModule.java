package com.yatatsu.passiveviewsample.dagger.module;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.yatatsu.passiveviewsample.dagger.scope.ApplicationScope;
import com.yatatsu.passiveviewsample.data.api.GitHub;
import com.yatatsu.passiveviewsample.data.api.GitHubService;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;


@Module
public class GithubApiModule {

    @ApplicationScope
    @Provides
    Gson provideGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @ApplicationScope
    @Provides
    GitHubService provideGithubApiService(OkHttpClient okHttpClient,
                                          Scheduler scheduler,
                                          Gson gson) {
        return new GitHub(okHttpClient, scheduler, gson);
    }
}
