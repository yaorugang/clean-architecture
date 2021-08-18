package com.yaorugang.afterpay.ui.carlist

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaorugang.afterpay.databinding.CarItemLayoutBinding
import com.yaorugang.afterpay.domain.model.Car
import com.yaorugang.afterpay.ui.utils.toCarItem

class CarListAdapter(val carItems: ArrayList<Car> = ArrayList()) :
    RecyclerView.Adapter<CarListAdapter.CarItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarItemViewHolder {
        return CarItemViewHolder(parent.context, CarItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return carItems.size
    }

    override fun onBindViewHolder(holder: CarItemViewHolder, position: Int) {
        holder.bind(carItems[position])
    }

    class CarItemViewHolder(private val context: Context, private val view: CarItemLayoutBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(car: Car) {
            view.carItem = car.toCarItem(context)
        }
    }
}