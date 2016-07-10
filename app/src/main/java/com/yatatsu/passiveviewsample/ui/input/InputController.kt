package com.yatatsu.passiveviewsample.ui.input


import com.yatatsu.passiveviewsample.ui.base.Controller

class InputController : Controller<InputScreen>() {

  fun onSubmitEditText(input: String?) {
    if (input == null || input.isEmpty()) {
      screen?.showError("input must not be empty.")
      return
    }
    val trimmed = input.trim { it <= ' ' }
    if (trimmed.contains(" ")) {
      screen?.showError("should be one word.")
    } else {
      screen?.hideError()
      screen?.navigateToUserScreen(trimmed)
    }
  }
}
