package com.yatatsu.passiveviewsample.dagger.module;


import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.yatatsu.passiveviewsample.data.api.GitHubService;
import com.yatatsu.passiveviewsample.data.api.MockGithub;

import rx.Scheduler;


public class MockGithubApiModule extends GithubApiModule {

    private GitHubService mockGithubService;

    public MockGithubApiModule() {

    }

    public MockGithubApiModule(GitHubService mockGithubService) {
        this.mockGithubService = mockGithubService;
    }

    @Override
    GitHubService provideGithubApiService(OkHttpClient okHttpClient,
                                          Scheduler scheduler,
                                          Gson gson) {
        if (mockGithubService != null) {
            return mockGithubService;
        }
        return new MockGithub();
    }
}