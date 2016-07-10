package com.yatatsu.passiveviewsample

import android.app.Application
import com.yatatsu.passiveviewsample.dagger.component.BaseComponent
import com.yatatsu.passiveviewsample.dagger.component.DaggerAppComponent
import com.yatatsu.passiveviewsample.dagger.component.DaggerBaseComponent
import com.yatatsu.passiveviewsample.dagger.module.AppModule
import timber.log.Timber


class PVSApplication : Application() {

  override fun onCreate() {
    super.onCreate()

    val appComponent = DaggerAppComponent.builder().appModule(AppModule(this)).build()
    baseComponent = DaggerBaseComponent.builder().appComponent(appComponent).build()
    Timber.plant(Timber.DebugTree())
  }

  companion object {

    var baseComponent: BaseComponent? = null
      private set
  }
}