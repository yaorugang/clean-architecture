package com.yaorugang.afterpay.ui.carlist

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class ErrorData(
    @DrawableRes val errorImageRes: Int,
    @StringRes val errorMessageRes: Int
)
