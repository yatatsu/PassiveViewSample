package com.yatatsu.passiveviewsample.dagger.module

import dagger.Module
import dagger.Provides
import rx.Scheduler
import rx.android.schedulers.AndroidSchedulers

/**
 * ThreadingModule
 */
@Module
open class ThreadingModule {

  @Provides
  open fun provideMainThread(): Scheduler {
    return AndroidSchedulers.mainThread()
  }
}
