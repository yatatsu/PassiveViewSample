package com.yatatsu.passiveviewsample.dagger.component


import com.yatatsu.passiveviewsample.dagger.module.ControllerModule
import com.yatatsu.passiveviewsample.dagger.scope.ActivityScope
import com.yatatsu.passiveviewsample.ui.input.InputActivity
import com.yatatsu.passiveviewsample.ui.repos.ReposActivity
import com.yatatsu.passiveviewsample.ui.user.UserActivity

import dagger.Component

@ActivityScope
@Component(dependencies = arrayOf(BaseComponent::class), modules = arrayOf(ControllerModule::class))
interface ActivityInjectorComponent {
  fun inject(activity: InputActivity)
  fun inject(activity: UserActivity)
  fun inject(activity: ReposActivity)
}
