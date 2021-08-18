package com.yaorugang.afterpay.data.api

import com.yaorugang.afterpay.data.api.response.CarResponse
import retrofit2.http.GET

interface CarsApi {
    @GET("cars.json")
    suspend fun getCars(): List<CarResponse>
}