package com.yatatsu.passiveviewsample.dagger;

import dagger.Component;


@Component(modules = {NetworkModule.class, ThreadingModule.class, ApiModule.class},
        dependencies = AppComponent.class)
public interface ApiComponent {
}
