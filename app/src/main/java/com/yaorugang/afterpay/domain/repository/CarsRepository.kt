package com.yaorugang.afterpay.domain.repository

import com.yaorugang.afterpay.domain.model.Car

interface CarsRepository {
    suspend fun getCars(): List<Car>
}