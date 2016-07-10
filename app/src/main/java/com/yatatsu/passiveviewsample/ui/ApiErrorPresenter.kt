package com.yatatsu.passiveviewsample.ui


import java.net.UnknownHostException

import retrofit.HttpException

object ApiErrorPresenter {

  fun getErrorMessage(e: Throwable): String {
    if (e is UnknownHostException) {
      return "No internet"
    }
    if (e is HttpException) {
      if (e.code() == 404) {
        return "Not Found"
      }
    }
    return "Unknown error"
  }
}
