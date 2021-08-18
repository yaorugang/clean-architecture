package com.yaorugang.afterpay.injection.modules

import com.yaorugang.afterpay.data.repository.CarsRepositoryImpl
import com.yaorugang.afterpay.domain.repository.CarsRepository
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCarsRepository(impl: CarsRepositoryImpl): CarsRepository
}