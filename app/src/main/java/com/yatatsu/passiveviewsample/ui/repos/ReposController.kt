package com.yatatsu.passiveviewsample.ui.repos


import com.yatatsu.passiveviewsample.data.api.GitHubService
import com.yatatsu.passiveviewsample.data.model.Repository
import com.yatatsu.passiveviewsample.ui.ApiErrorPresenter
import com.yatatsu.passiveviewsample.ui.base.Controller

class ReposController(private val github: GitHubService) : Controller<ReposScreen>() {
  private var username: String? = null

  fun onCreateScreen(username: String?) {
    this.username = username
  }

  fun onStartScreen() {
    register(github.getRepositories(username!!).subscribe(
        { repositories -> screen?.showRepositories(repositories) }) { throwable ->
      throwable.printStackTrace()
      screen?.showError(
          ApiErrorPresenter.getErrorMessage(throwable))
    })
  }

  fun onStopScreen() {
    unSubscribe()
  }

  fun onItemClick(repository: Repository) {
    screen?.openUrl(repository.htmlUrl!!)
  }
}
