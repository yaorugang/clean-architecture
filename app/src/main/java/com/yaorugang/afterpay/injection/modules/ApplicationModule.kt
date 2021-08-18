package com.yaorugang.afterpay.injection.modules

import android.content.Context
import com.google.gson.Gson
import com.yaorugang.afterpay.AfterpayApplication
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {

    @Provides
    @Singleton
    fun provideContext(app: AfterpayApplication): Context {
        return app
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return Gson()
    }
}