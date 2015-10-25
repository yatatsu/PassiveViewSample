package com.yatatsu.passiveviewsample;

import com.yatatsu.passiveviewsample.dagger.scope.ActivityScope;
import com.yatatsu.passiveviewsample.data.api.GitHubService;
import com.yatatsu.passiveviewsample.ui.repos.ReposController;
import com.yatatsu.passiveviewsample.ui.user.UserController;

import dagger.Module;
import dagger.Provides;

/**
 * ControllerModule for Test
 */
@Module
public class TestControllerModule {

    @Provides
    @ActivityScope
    UserController provideUserController(GitHubService gitHubService) {
        return new UserController(gitHubService);
    }

    @Provides
    @ActivityScope
    ReposController provideReposController(GitHubService gitHubService) {
        return new ReposController(gitHubService);
    }
}
