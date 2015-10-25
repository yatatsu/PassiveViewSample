package com.yatatsu.passiveviewsample;

import android.app.Application;

import com.yatatsu.passiveviewsample.dagger.component.AppComponent;
import com.yatatsu.passiveviewsample.dagger.component.BaseComponent;
import com.yatatsu.passiveviewsample.dagger.component.DaggerAppComponent;
import com.yatatsu.passiveviewsample.dagger.component.DaggerBaseComponent;
import com.yatatsu.passiveviewsample.dagger.module.AppModule;
import com.yatatsu.passiveviewsample.dagger.module.MockGithubApiModule;
import com.yatatsu.passiveviewsample.dagger.module.MockNetworkModule;
import com.yatatsu.passiveviewsample.dagger.module.MockThreadingModule;

/**
 * Helper for injection
 */
public class TestInjectionHelper {

    private static TestInjectionHelper ourInstance = new TestInjectionHelper();
    private static BaseComponent baseComponent;

    // Use as singleton
    public static TestInjectionHelper getInstance() {
        return ourInstance;
    }

    private TestInjectionHelper() {
        AppComponent appComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(new Application()))
                .build();
        baseComponent = DaggerBaseComponent.builder()
                .appComponent(appComponent)
                .networkModule(new MockNetworkModule())
                .threadingModule(new MockThreadingModule())
                .githubApiModule(new MockGithubApiModule())
                .build();
    }

    /**
     * Return component inject controller
     * @return component for test
     */
    public TestInjectorComponent getInjectorComponent() {
        return DaggerTestInjectorComponent.builder()
                .baseComponent(baseComponent)
                .testControllerModule(new TestControllerModule())
                .build();
    }
}
