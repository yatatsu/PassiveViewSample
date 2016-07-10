package com.yatatsu.passiveviewsample.data.api

import com.yatatsu.passiveviewsample.data.model.Repository
import com.yatatsu.passiveviewsample.data.model.User

import retrofit.http.GET
import retrofit.http.Path
import rx.Observable


interface GitHubService {

  @GET("/users/{username}")
  fun getUser(
      @Path("username") username: String): Observable<User>

  @GET("/users/{username}/repos")
  fun getRepositories(
      @Path("username") username: String): Observable<List<Repository>>
}
