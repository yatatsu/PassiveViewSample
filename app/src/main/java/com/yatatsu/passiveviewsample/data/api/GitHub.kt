package com.yatatsu.passiveviewsample.data.api

import com.google.gson.Gson
import com.squareup.okhttp.OkHttpClient
import com.yatatsu.passiveviewsample.data.model.Repository
import com.yatatsu.passiveviewsample.data.model.User

import retrofit.GsonConverterFactory
import retrofit.Retrofit
import retrofit.RxJavaCallAdapterFactory
import rx.Observable
import rx.Scheduler
import rx.schedulers.Schedulers


class GitHub(okHttpClient: OkHttpClient, private val scheduler: Scheduler, gson: Gson) : GitHubService {
  private val gitHubService: GitHubService

  init {
    gitHubService = Retrofit.Builder().baseUrl("https://api.github.com").addConverterFactory(
        GsonConverterFactory.create(gson)).addCallAdapterFactory(
        RxJavaCallAdapterFactory.create()).client(okHttpClient).build().create(
        GitHubService::class.java)
  }

  override fun getUser(username: String): Observable<User> {
    return gitHubService.getUser(username).subscribeOn(Schedulers.io()).observeOn(scheduler)
  }

  override fun getRepositories(username: String): Observable<List<Repository>> {
    return gitHubService.getRepositories(username).subscribeOn(Schedulers.io()).observeOn(scheduler)
  }
}
