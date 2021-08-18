package com.yaorugang.afterpay.ui.databinding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.yaorugang.afterpay.domain.model.Car
import com.yaorugang.afterpay.ui.carlist.CarListAdapter

@BindingAdapter("carItems")
fun setCarItems(recyclerView: RecyclerView, carItems: List<Car>) {
    (recyclerView.adapter as? CarListAdapter)?.let { carListAdapter ->
        carListAdapter.carItems.apply {
            clear()
            addAll(carItems)
        }
        carListAdapter.notifyDataSetChanged()
    }
}