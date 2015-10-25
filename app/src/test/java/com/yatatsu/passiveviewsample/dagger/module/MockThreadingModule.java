package com.yatatsu.passiveviewsample.dagger.module;

import rx.Scheduler;
import rx.schedulers.Schedulers;

public class MockThreadingModule extends ThreadingModule {

    @Override
    public Scheduler provideMainThread() {
        return Schedulers.immediate();
    }
}