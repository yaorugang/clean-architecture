package com.yaorugang.afterpay.data.api.response

data class CarResponse(
    val make: CarMakeResponse,
    val color: String,
    val year: Int,
    val configuration: CarConfigurationResponse,
    val origin: String?,
    val mpg: Int?,
    val image: String?,
    val price: Int
)

data class CarMakeResponse(
    val manufacturer: String,
    val model: String
)

data class CarConfigurationResponse(
    val body: String,
    val cylinders: Int?,
    val horsepower: Int?
)
