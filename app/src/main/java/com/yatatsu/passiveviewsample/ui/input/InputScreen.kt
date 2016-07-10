package com.yatatsu.passiveviewsample.ui.input


import com.yatatsu.passiveviewsample.ui.base.Screen

interface InputScreen : Screen {
  fun navigateToUserScreen(username: String)
  fun showError(message: String)
  fun hideError()
}
