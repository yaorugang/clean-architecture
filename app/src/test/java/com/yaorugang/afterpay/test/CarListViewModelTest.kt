package com.yaorugang.afterpay.test

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.yaorugang.afterpay.R
import com.yaorugang.afterpay.domain.manager.CarsManager
import com.yaorugang.afterpay.mock.MockCarsRepository
import com.yaorugang.afterpay.mock.MockEmptyCarsRepository
import com.yaorugang.afterpay.mock.MockErrorCarsRepository
import com.yaorugang.afterpay.ui.carlist.CarListViewModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.TestRule

class CarListViewModelTest {

    @get:Rule
    var rule: TestRule = InstantTaskExecutorRule()

    @Test
    fun testCarItems() = runBlocking {
        val carsManager = CarsManager(MockCarsRepository())
        val viewModel = CarListViewModel(carsManager)

        viewModel.fetchCars()
        assertEquals(3, viewModel.carItems.value?.size)
    }

    @Test
    fun testEmptyCarItems() = runBlocking {
        val carsManager = CarsManager(MockEmptyCarsRepository())
        val viewModel = CarListViewModel(carsManager)

        viewModel.fetchCars()
        assertEquals(true, viewModel.showError.value)
        assertEquals(R.drawable.ic_empty_data, viewModel.errorData.value?.errorImageRes)
        assertEquals(R.string.empty_car_list_error, viewModel.errorData.value?.errorMessageRes)
    }

    @Test
    fun testErrorCarItems() = runBlocking {
        val carsManager = CarsManager(MockErrorCarsRepository())
        val viewModel = CarListViewModel(carsManager)

        viewModel.fetchCars()
        assertEquals(true, viewModel.showError.value)
        assertEquals(R.drawable.ic_something_wrong, viewModel.errorData.value?.errorImageRes)
        assertEquals(R.string.car_list_fetching_error, viewModel.errorData.value?.errorMessageRes)
    }
}