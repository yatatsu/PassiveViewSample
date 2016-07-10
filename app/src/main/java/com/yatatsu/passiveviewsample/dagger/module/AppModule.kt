package com.yatatsu.passiveviewsample.dagger.module

import android.app.Application
import android.content.Context

import javax.inject.Singleton

import dagger.Module
import dagger.Provides

@Module
class AppModule(application: Application) {

  private val applicationContext: Context

  init {
    applicationContext = application
  }

  @Singleton
  @Provides
  fun provideApplicationContext(): Context {
    return applicationContext
  }
}
