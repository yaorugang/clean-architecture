package com.yaorugang.afterpay.injection.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.yaorugang.afterpay.injection.ViewModelFactory
import com.yaorugang.afterpay.ui.MainActivity
import com.yaorugang.afterpay.ui.cardetails.CarDetailsFragment
import com.yaorugang.afterpay.ui.cardetails.CarDetailsViewModel
import com.yaorugang.afterpay.ui.carlist.CarListFragment
import com.yaorugang.afterpay.ui.carlist.CarListViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap

@Module
abstract class UiModule {

    @Binds
    abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @ContributesAndroidInjector
    abstract fun mainActivity(): MainActivity

    @ContributesAndroidInjector
    abstract fun carListFragment(): CarListFragment

    @ContributesAndroidInjector
    abstract fun carDetailsFragment(): CarDetailsFragment

    @Binds
    @IntoMap
    @ViewModelKey(CarListViewModel::class)
    abstract fun bindCarListViewModel(viewModel: CarListViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CarDetailsViewModel::class)
    abstract fun bindCarDetailsViewModel(viewModel: CarDetailsViewModel): ViewModel
}