package com.yaorugang.afterpay.ui.carlist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.yaorugang.afterpay.databinding.CarItemLayoutBinding
import com.yaorugang.afterpay.domain.model.Car

class CarListAdapter(val carItems: ArrayList<Car> = ArrayList()) :
    RecyclerView.Adapter<CarListAdapter.CarItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarItemViewHolder {
        return CarItemViewHolder(CarItemLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return carItems.size
    }

    override fun onBindViewHolder(holder: CarItemViewHolder, position: Int) {
        holder.bind(carItems[position])
    }

    class CarItemViewHolder(private val view: CarItemLayoutBinding) : RecyclerView.ViewHolder(view.root) {
        fun bind(car: Car) {
//            view.jobTitle.text = job.title
//            view.companyName.text = job.companyName
//            view.teaser.text = job.teaser
        }
    }
}