package com.yaorugang.afterpay.mock

import com.yaorugang.afterpay.domain.model.Car
import com.yaorugang.afterpay.domain.model.CarConfiguration
import com.yaorugang.afterpay.domain.model.CarMake
import com.yaorugang.afterpay.domain.repository.CarsRepository

class MockCarsRepository: CarsRepository {
    private val cars: List<Car>

    init {
        val car1 = Car(
            make = CarMake(
                manufacturer = "Honda",
                model = "Civic"
            ),
            color = "Red",
            year = 2019,
            configuration = CarConfiguration(
                body = "Saloon",
                cylinders = 4,
                horsepower = 130
            ),
            origin = "Japan",
            mpg = 19,
            imageUrl = "images/honda_civic_1.jpg",
            price = 17500
        )

        val car2 = Car(
            make = CarMake(
                manufacturer = "BMW",
                model = "X7"
            ),
            color = "Black",
            year = 2020,
            configuration = CarConfiguration(
                body = "Coupe",
                cylinders = 6,
                horsepower = 240
            ),
            origin = "Germany",
            mpg = 25,
            imageUrl = "images/bmw_x7_1.jpg",
            price = 47000
        )

        val car3 = Car(
            make = CarMake(
                manufacturer = "Hyundai",
                model = "Atos Prime"
            ),
            color = "Blue",
            year = 2010,
            configuration = CarConfiguration(
                body = "Hatchback",
                cylinders = 4,
                horsepower = 100
            ),
            origin = "Korea",
            mpg = 25,
            imageUrl = "images/hyundai_atos_prime_1.jpg",
            price = 9000
        )

        cars = listOf(car1, car2, car3)
    }

    override suspend fun getCars(): List<Car> {
        return cars
    }
}