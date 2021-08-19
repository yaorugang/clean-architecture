package com.yaorugang.afterpay.mock

import com.yaorugang.afterpay.domain.model.Car
import com.yaorugang.afterpay.domain.repository.CarsRepository

class MockEmptyCarsRepository: CarsRepository {
    private val cars = listOf<Car>()

    override suspend fun getCars(): List<Car> {
        return cars
    }
}