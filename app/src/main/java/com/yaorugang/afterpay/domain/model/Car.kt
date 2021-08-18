package com.yaorugang.afterpay.domain.model

data class Car(
    val make: CarMake,
    val color: String,
    val year: Int,
    val configuration: CarConfiguration,
    val origin: String?,
    val mpg: Int?,
    val imageUrl: String?,
    val price: Int
)

data class CarMake(
    val manufacturer: String,
    val model: String
)

data class CarConfiguration(
    val body: String,
    val cylinders: Int?,
    val horsepower: Int?
)
