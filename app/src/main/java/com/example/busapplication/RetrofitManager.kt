package com.example.busapplication

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitManager {
    private const val busApiUrl = "http://openapi.tago.go.kr/openapi/service/ArvlInfoInqireService/"
    // 공공 api 주소
    private const val mockApiUrl = "https://8503e19a-6e3b-4195-a10a-375a80d9a041.mock.pstmn.io/"
    // mock api 주소

    val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(busApiUrl)
            .build()
            .create(Service::class.java) // 공공 api Retrofit.Builder

    val postmanRetrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(mockApiUrl)
            .build()
            .create(Service::class.java) // mock api Retrofit.Builder
}