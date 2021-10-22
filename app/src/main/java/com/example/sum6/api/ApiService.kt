package com.example.sum6.api

import com.example.sum6.Content
import com.example.sum6.HouseData
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("f4864c66-ee04-4e7f-88a2-2fbd912ca5ab")
    fun fetchAllData(): Call<HouseData>

}