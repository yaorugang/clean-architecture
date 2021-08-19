package com.yaorugang.afterpay.mock

import com.yaorugang.afterpay.domain.exception.DomainException
import com.yaorugang.afterpay.domain.model.Car
import com.yaorugang.afterpay.domain.repository.CarsRepository

class MockErrorCarsRepository: CarsRepository {

    override suspend fun getCars(): List<Car> {
        throw DomainException()
    }
}