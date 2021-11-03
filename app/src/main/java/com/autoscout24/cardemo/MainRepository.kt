package com.autoscout24.cardemo

import com.autoscout24.cardemo.network.RetrofitService

class MainRepository constructor(private val retrofitService: RetrofitService) {

    suspend fun getAllCars() = retrofitService.getAllCars()

}