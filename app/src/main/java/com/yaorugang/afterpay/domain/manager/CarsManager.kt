package com.yaorugang.afterpay.domain.manager

import com.yaorugang.afterpay.domain.exception.DomainException
import com.yaorugang.afterpay.domain.exception.EmptyDataException
import com.yaorugang.afterpay.domain.model.Car
import com.yaorugang.afterpay.domain.repository.CarsRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CarsManager @Inject constructor(private val carsRepository: CarsRepository) {
    suspend fun getCars(): List<Car> {
        val cars = try {
            carsRepository.getCars()
        } catch (e: Exception) {
            throw DomainException()
        }

        if (cars.isEmpty()) {
            throw EmptyDataException()
        }

        return cars
    }
}