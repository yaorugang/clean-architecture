package com.yaorugang.afterpay.injection

import com.yaorugang.afterpay.injection.modules.ApplicationModule
import com.yaorugang.afterpay.injection.modules.DataModule
import com.yaorugang.afterpay.injection.modules.RepositoryModule
import com.yaorugang.afterpay.injection.modules.UiModule
import com.yaorugang.afterpay.AfterpayApplication
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class,
        UiModule::class,
        DataModule::class,
        RepositoryModule::class,
        ApplicationModule::class]
)

interface AfterpayApplicationComponent : AndroidInjector<AfterpayApplication> {
    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<AfterpayApplication>
}