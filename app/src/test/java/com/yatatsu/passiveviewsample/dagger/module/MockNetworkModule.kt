package com.yatatsu.passiveviewsample.dagger.module


import android.content.Context

import com.squareup.okhttp.OkHttpClient

class MockNetworkModule : NetworkModule() {

  override fun provideOkHttpClient(context: Context): OkHttpClient {
    return OkHttpClient()
  }
}