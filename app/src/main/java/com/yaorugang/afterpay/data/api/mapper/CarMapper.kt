package com.yaorugang.afterpay.data.api.mapper

import com.yaorugang.afterpay.BuildConfig
import com.yaorugang.afterpay.data.api.response.CarResponse
import com.yaorugang.afterpay.domain.model.Car
import com.yaorugang.afterpay.domain.model.CarConfiguration
import com.yaorugang.afterpay.domain.model.CarMake
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CarMapper @Inject constructor() {
    operator fun invoke(carResponse: CarResponse): Car {
        return Car(
            make = CarMake(
                manufacturer = carResponse.make.manufacturer,
                model = carResponse.make.model
            ),
            color = carResponse.color,
            year = carResponse.year,
            configuration = CarConfiguration(
                body = carResponse.configuration.body,
                cylinders = carResponse.configuration.cylinders,
                horsepower = carResponse.configuration.horsepower
            ),
            origin = carResponse.origin,
            mpg = carResponse.mpg,
            imageUrl = BuildConfig.IMAGE_BASE_URL + carResponse.image,
            price = carResponse.price
        )
    }
}