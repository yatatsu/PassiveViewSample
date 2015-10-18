package com.yatatsu.passiveviewsample.dagger.component;


import com.yatatsu.passiveviewsample.dagger.module.ControllerModule;
import com.yatatsu.passiveviewsample.dagger.scope.ActivityScope;
import com.yatatsu.passiveviewsample.ui.input.InputActivity;
import com.yatatsu.passiveviewsample.ui.repos.ReposActivity;
import com.yatatsu.passiveviewsample.ui.user.UserActivity;

import dagger.Component;

@ActivityScope
@Component(
        dependencies = {BaseComponent.class},
        modules = {ControllerModule.class}
)
public interface ActivityInjectorComponent {
    void inject(InputActivity activity);
    void inject(UserActivity activity);
    void inject(ReposActivity activity);
}
