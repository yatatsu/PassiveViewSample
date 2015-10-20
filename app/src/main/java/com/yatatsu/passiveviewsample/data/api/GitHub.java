package com.yatatsu.passiveviewsample.data.api;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.yatatsu.passiveviewsample.data.model.Repository;
import com.yatatsu.passiveviewsample.data.model.User;

import java.util.List;

import retrofit.GsonConverterFactory;
import retrofit.Retrofit;
import retrofit.RxJavaCallAdapterFactory;
import rx.Observable;
import rx.Scheduler;
import rx.schedulers.Schedulers;


public class GitHub implements GitHubService {

    private final Scheduler scheduler;
    private GitHubService gitHubService;

    public GitHub(OkHttpClient okHttpClient, Scheduler scheduler, Gson gson) {
        gitHubService = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .client(okHttpClient)
                .build()
                .create(GitHubService.class);
        this.scheduler = scheduler;
    }

    @Override
    public Observable<User> getUser(String username) {
        return gitHubService.getUser(username)
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler);
    }

    @Override
    public Observable<List<Repository>> getRepositories(String username) {
        return gitHubService.getRepositories(username)
                .subscribeOn(Schedulers.io())
                .observeOn(scheduler);
    }
}
