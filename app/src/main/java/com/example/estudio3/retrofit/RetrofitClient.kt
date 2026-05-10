package com.example.estudio3.retrofit

import com.example.estudio3.interfaces.InterfaceApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL= "https://www.swapi.tech/api/"

    val servicio: InterfaceApi by lazy {
        Retrofit.Builder().baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(InterfaceApi::class.java)
    }

}