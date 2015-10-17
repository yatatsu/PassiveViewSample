package com.yatatsu.passiveviewsample.dagger.module;

import dagger.Module;
import dagger.Provides;
import rx.Scheduler;
import rx.android.schedulers.AndroidSchedulers;

/**
 * ThreadingModule
 */
@Module
public class ThreadingModule {

    @Provides
    public Scheduler provideMainThread() {
        return AndroidSchedulers.mainThread();
    }
}
