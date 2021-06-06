package com.example.busapplication

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query


interface Service {
    @GET("getRouteAcctoSpcifySttnAccesBusLcInfo")
    fun getBusInfo(
            @Query("ServiceKey") serviceKey: String,
            @Query("routeId") routeId: String,
            @Query("nodeId") nodeId: String,
            @Query("cityCode") cityCode: Int
    ): Call<Bus>

    @GET("getRouteAcctoSpcifySttnAccesBusLcInfo")
    fun getPostmanBusInfo(
            @Header("ServiceKey") serviceKey: String, // 보안을 위해 추가 Query로 날리면 url뒤에 붙어서 보안에 매우 취약함
            @Query("routeId") routeId: String,
            @Query("cityCode") cityCode: String
    ): Call<Bus>
}