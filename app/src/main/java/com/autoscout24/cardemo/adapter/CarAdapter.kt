package com.autoscout24.cardemo

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.autoscout24.cardemo.databinding.ItemRecyclerviewCarBinding
import com.bumptech.glide.Glide
import com.autoscout24.cardemo.model.CarDetailsItem

class CarAdapter : RecyclerView.Adapter<MainViewHolder>() {

    var carList = mutableListOf<CarDetailsItem>()

    fun setCar(cars: List<CarDetailsItem>) {
        this.carList = cars.toMutableList()
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRecyclerviewCarBinding.inflate(inflater, parent, false)
        return MainViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) {

        val car = carList[position]
        holder.binding.txtCarname.text = car.make
        holder.binding.tvFuel.text = car.fuel
        holder.binding.tvModel.text = car.model
        holder.binding.tvColor.text = car.colour
        holder.binding.tvDesc.text = car.description
        holder.binding.tvMake.text = car.make

        var carImage = "http://via.placeholder.com/300.png"
        if(!car.images.isNullOrEmpty()) {
            for (i in 0 until car.images.size) {
                carImage = car.images?.get(i)?.url
            }
            Glide.with(holder.itemView.context).load(carImage).into(holder.binding.imageView)
        }
        holder.binding.imageView.setOnClickListener {
            Log.v("Test Clicked","Test Clicked")
        }
    }

    override fun getItemCount(): Int {
        return carList.size
    }
}


class MainViewHolder(val binding: ItemRecyclerviewCarBinding) : RecyclerView.ViewHolder(binding.root) {

}

