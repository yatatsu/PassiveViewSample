package com.yatatsu.passiveviewsample.dagger.module


import com.google.gson.Gson
import com.squareup.okhttp.OkHttpClient
import com.yatatsu.passiveviewsample.data.api.GitHubService
import com.yatatsu.passiveviewsample.data.api.MockGithub

import rx.Scheduler


class MockGithubApiModule : GithubApiModule {

  private var mockGithubService: GitHubService? = null

  constructor() {

  }

  constructor(mockGithubService: GitHubService) {
    this.mockGithubService = mockGithubService
  }

  override fun provideGithubApiService(okHttpClient: OkHttpClient,
      scheduler: Scheduler,
      gson: Gson): GitHubService {
    if (mockGithubService != null) {
      return mockGithubService!!
    }
    return MockGithub()
  }
}