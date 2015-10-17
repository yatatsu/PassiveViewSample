package com.yatatsu.passiveviewsample.data.network;

import com.squareup.okhttp.OkHttpClient;
import com.yatatsu.passiveviewsample.data.model.Repository;
import com.yatatsu.passiveviewsample.data.model.User;

import java.util.List;

import rx.Observable;
import rx.Scheduler;


public class GithubApi implements GithubApiService {

    public GithubApi(OkHttpClient okHttpClient, Scheduler scheduler) {

    }

    @Override
    public Observable<User> getUser(String userName) {
        return null;
    }

    @Override
    public Observable<List<Repository>> getRepositories(String userName) {
        return null;
    }
}
