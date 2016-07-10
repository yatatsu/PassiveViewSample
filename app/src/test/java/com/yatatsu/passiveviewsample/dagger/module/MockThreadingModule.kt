package com.yatatsu.passiveviewsample.dagger.module

import rx.Scheduler
import rx.schedulers.Schedulers

class MockThreadingModule : ThreadingModule() {

  override fun provideMainThread(): Scheduler {
    return Schedulers.immediate()
  }
}