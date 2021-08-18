package com.yaorugang.afterpay.ui.utils

import android.content.Context
import com.yaorugang.afterpay.R
import com.yaorugang.afterpay.domain.model.Car
import com.yaorugang.afterpay.ui.carlist.CarItem

fun Car.toCarItem(context: Context): CarItem {
    val currencySymbol = context.getString(R.string.currency_symbol)

    var extraInfo = context.getString(R.string.car_color).format(color)
    if (origin?.isNotBlank() == true) {
        extraInfo += context.getString(R.string.car_origin).format(origin)
    }
    configuration.cylinders?.let { cylinders ->
        extraInfo += context.getString(R.string.car_engine_cylinders).format(cylinders)
        configuration.horsepower?.let { horsepower ->
            extraInfo += context.getString(R.string.car_engine_horsepower).format(horsepower)
        }
    }

    return CarItem(
        imageUrl = imageUrl,
        title = "$year ${make.manufacturer} ${make.model}",
        price = "$currencySymbol$price",
        extraInfo = extraInfo
    )
}