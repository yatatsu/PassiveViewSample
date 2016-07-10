package com.yatatsu.passiveviewsample.dagger.module

import com.yatatsu.passiveviewsample.dagger.scope.ActivityScope
import com.yatatsu.passiveviewsample.data.api.GitHubService
import com.yatatsu.passiveviewsample.ui.input.InputController
import com.yatatsu.passiveviewsample.ui.repos.ReposController
import com.yatatsu.passiveviewsample.ui.user.UserController

import dagger.Module
import dagger.Provides


@Module
class ControllerModule {

  @Provides
  @ActivityScope
  fun provideInputController(): InputController {
    return InputController()
  }

  @Provides
  @ActivityScope
  fun provideUserController(gitHubService: GitHubService): UserController {
    return UserController(gitHubService)
  }

  @Provides
  @ActivityScope
  fun provideReposController(gitHubService: GitHubService): ReposController {
    return ReposController(gitHubService)
  }
}
