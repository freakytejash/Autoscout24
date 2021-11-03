package com.autoscout24.cardemo.network

import com.autoscout24.cardemo.model.CarDetailsItem
import com.autoscout24.cardemo.model.CarNotesItem
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface RetrofitService {

    @GET(".")
    suspend fun getAllCars() : Response<List<CarDetailsItem>>

    @GET("{https://private-e7c3d8-classifiednotes.apiary-mock.com/}")
    suspend fun getNotes() : Response<List<CarNotesItem>>

    companion object {
        var retrofitService: RetrofitService? = null
        val baseURL = "http://private-fe87c-simpleclassifieds.apiary-mock.com/"
        val baseURLNote ="https://private-e7c3d8-classifiednotes.apiary-mock.com/"

        fun getInstance() : RetrofitService {
            if (retrofitService == null) {
                val retrofit = Retrofit.Builder()
                    .baseUrl(baseURL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                retrofitService = retrofit.create(RetrofitService::class.java)
            }
            return retrofitService!!
        }

    }
}