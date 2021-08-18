package com.yaorugang.afterpay

import com.yaorugang.afterpay.injection.DaggerAfterpayApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class AfterpayApplication: DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        return DaggerAfterpayApplicationComponent.factory().create(this)
    }
}