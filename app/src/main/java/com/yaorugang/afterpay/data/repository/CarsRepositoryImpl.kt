package com.yaorugang.afterpay.data.repository

import com.yaorugang.afterpay.data.api.CarsApi
import com.yaorugang.afterpay.data.api.mapper.CarMapper
import com.yaorugang.afterpay.domain.model.Car
import com.yaorugang.afterpay.domain.repository.CarsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class CarsRepositoryImpl @Inject constructor(
    private val carsApi: CarsApi,
    private val carMapper: CarMapper
): CarsRepository {

    override suspend fun getCars(): List<Car> = withContext(Dispatchers.IO) {
        carsApi.getCars().map {
            carMapper(it)
        }
    }
}