package com.yatatsu.passiveviewsample.ui.user

import com.yatatsu.passiveviewsample.data.api.GitHubService
import com.yatatsu.passiveviewsample.ui.ApiErrorPresenter
import com.yatatsu.passiveviewsample.ui.base.Controller


class UserController(private val gitHubService: GitHubService) : Controller<UserScreen>() {
  private var username: String? = null

  fun onCreateScreen(username: String?) {
    this.username = username
    register(gitHubService.getUser(username!!).subscribe(
        { user ->
          screen?.showUserImage(user.avatarUrl!!)
          screen?.showUserName(user.name!!)
        }) { throwable ->
      throwable.printStackTrace()
      screen?.showErrorDialog(
          ApiErrorPresenter.getErrorMessage(throwable))
    })
  }

  fun onClickReposButton() {
    screen?.navigateToReposScreen(username!!)
  }

  fun onDestroyScreen() {
    unSubscribe()
  }
}
