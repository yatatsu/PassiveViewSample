package com.yatatsu.passiveviewsample.ui.base


import rx.Subscription
import rx.subscriptions.CompositeSubscription

abstract class Controller<T : Screen> {

  protected var screen: T? = null
    private set
  private var compositeSubscription: CompositeSubscription? = null

  fun registerScreen(screen: T) {
    this.screen = screen
  }

  protected fun register(subscription: Subscription) {
    if (compositeSubscription == null) {
      compositeSubscription = CompositeSubscription()
    }
    compositeSubscription!!.add(subscription)
  }

  protected fun unSubscribe() {
    if (compositeSubscription != null) {
      compositeSubscription!!.unsubscribe()
      compositeSubscription = null
    }
  }
}
