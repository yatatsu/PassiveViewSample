package com.yatatsu.passiveviewsample.data.api;

import com.yatatsu.passiveviewsample.data.model.Repository;
import com.yatatsu.passiveviewsample.data.model.User;

import java.util.List;

import retrofit.http.Path;
import rx.Observable;

/**
 * Mock Github Api
 */
public class MockGithub implements GitHubService {

    @Override
    public Observable<User> getUser(@Path("username") String username) {
        return Observable.just(MockData.mockUser());
    }

    @Override
    public Observable<List<Repository>> getRepositories(@Path("username") String username) {
        return Observable.just(MockData.mockRepositories());
    }
}
