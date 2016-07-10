package com.yatatsu.passiveviewsample.ui.user

import com.yatatsu.passiveviewsample.ui.base.Screen


interface UserScreen : Screen {
  fun showUserImage(avatarUrl: String)
  fun showUserName(fullName: String)
  fun showErrorDialog(message: String)
  fun navigateToReposScreen(username: String)
}
