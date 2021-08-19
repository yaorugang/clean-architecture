package com.yaorugang.afterpay.ui.databinding

import android.widget.TextView
import androidx.annotation.StringRes
import androidx.databinding.BindingAdapter

@BindingAdapter("textRes")
fun setText(textView: TextView, @StringRes textRes: Int) {
    if (textRes != 0) {
        textView.setText(textRes)
    }
}