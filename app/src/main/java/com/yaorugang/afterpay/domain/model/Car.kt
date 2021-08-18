package com.yaorugang.afterpay.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Car(
    val make: CarMake,
    val color: String,
    val year: Int,
    val configuration: CarConfiguration,
    val origin: String?,
    val mpg: Int?,
    val imageUrl: String?,
    val price: Int
): Parcelable

@Parcelize
data class CarMake(
    val manufacturer: String,
    val model: String
): Parcelable

@Parcelize
data class CarConfiguration(
    val body: String,
    val cylinders: Int?,
    val horsepower: Int?
): Parcelable
