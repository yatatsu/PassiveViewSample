package com.yatatsu.passiveviewsample.ui.repos


import com.yatatsu.passiveviewsample.data.model.Repository
import com.yatatsu.passiveviewsample.ui.base.Screen

interface ReposScreen : Screen {
  fun showRepositories(repositories: List<Repository>)
  fun showError(message: String)
  fun openUrl(url: String)
}
