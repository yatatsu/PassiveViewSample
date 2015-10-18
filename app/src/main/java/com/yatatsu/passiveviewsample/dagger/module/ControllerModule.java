package com.yatatsu.passiveviewsample.dagger.module;

import com.yatatsu.passiveviewsample.dagger.scope.ActivityScope;
import com.yatatsu.passiveviewsample.ui.input.InputController;
import com.yatatsu.passiveviewsample.ui.repos.ReposController;
import com.yatatsu.passiveviewsample.ui.user.UserController;

import dagger.Module;
import dagger.Provides;


@Module
public class ControllerModule {

    @Provides
    @ActivityScope
    InputController provideInputController() {
        return new InputController();
    }

    @Provides
    @ActivityScope
    UserController provideUserController() {
        return new UserController();
    }

    @Provides
    @ActivityScope
    ReposController provideReposController() {
        return new ReposController();
    }
}
