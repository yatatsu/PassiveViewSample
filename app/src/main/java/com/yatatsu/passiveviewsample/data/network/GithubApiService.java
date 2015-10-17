package com.yatatsu.passiveviewsample.data.network;

import com.yatatsu.passiveviewsample.data.model.Repository;
import com.yatatsu.passiveviewsample.data.model.User;

import java.util.List;

import rx.Observable;


public interface GithubApiService {
    Observable<User> getUser(String userName);
    Observable<List<Repository>> getRepositories(String userName);
}
