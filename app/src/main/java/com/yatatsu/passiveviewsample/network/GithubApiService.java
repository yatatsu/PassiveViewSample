package com.yatatsu.passiveviewsample.network;

import com.yatatsu.passiveviewsample.data.model.Repository;
import com.yatatsu.passiveviewsample.data.model.User;

import java.util.List;

import rx.Observable;


public interface GithubApiService {
    Observable<User> getUser();
    Observable<List<Repository>> getRepositories();
}
