package com.yatatsu.passiveviewsample.dagger.module;


import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.yatatsu.passiveviewsample.data.api.GitHubService;
import com.yatatsu.passiveviewsample.data.api.MockGithub;

import rx.Scheduler;


public class MockGithubApiModule extends GithubApiModule {

    @Override
    GitHubService provideGithubApiService(OkHttpClient okHttpClient,
                                          Scheduler scheduler,
                                          Gson gson) {
        return new MockGithub();
    }
}