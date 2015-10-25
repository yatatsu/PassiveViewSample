package com.yatatsu.passiveviewsample;

import com.yatatsu.passiveviewsample.dagger.component.BaseComponent;
import com.yatatsu.passiveviewsample.dagger.scope.ActivityScope;
import com.yatatsu.passiveviewsample.ui.repos.ReposControllerTest;
import com.yatatsu.passiveviewsample.ui.user.UserControllerTest;

import dagger.Component;

@ActivityScope
@Component(dependencies = BaseComponent.class, modules = TestControllerModule.class)
public interface TestInjectorComponent {
    void inject(UserControllerTest userControllerTest);
    void inject(ReposControllerTest reposControllerTest);
}
