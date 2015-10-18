package com.yatatsu.passiveviewsample.dagger.component;


import com.yatatsu.passiveviewsample.dagger.module.ControllerModule;
import com.yatatsu.passiveviewsample.dagger.scope.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = {BaseComponent.class},
        modules = {ControllerModule.class}
)
public interface ActivityInjectorComponent {
}
