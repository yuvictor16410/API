package com.example.apidemo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkingInteractor {

    companion object{
        private val retrofit = Retrofit.Builder()
            .baseUrl("https://my-json-server.typicode.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val api: ApiDao = retrofit.create(ApiDao::class.java)
    }

}