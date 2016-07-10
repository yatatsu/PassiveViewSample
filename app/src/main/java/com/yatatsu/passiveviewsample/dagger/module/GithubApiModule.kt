package com.yatatsu.passiveviewsample.dagger.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.squareup.okhttp.OkHttpClient
import com.yatatsu.passiveviewsample.dagger.scope.ApplicationScope
import com.yatatsu.passiveviewsample.data.api.GitHub
import com.yatatsu.passiveviewsample.data.api.GitHubService

import dagger.Module
import dagger.Provides
import rx.Scheduler


@Module
open class GithubApiModule {

  @ApplicationScope
  @Provides
  fun provideGson(): Gson {
    return GsonBuilder().setFieldNamingPolicy(
        FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES).create()
  }

  @ApplicationScope
  @Provides
  open fun provideGithubApiService(okHttpClient: OkHttpClient,
      scheduler: Scheduler,
      gson: Gson): GitHubService {
    return GitHub(okHttpClient, scheduler, gson)
  }
}
