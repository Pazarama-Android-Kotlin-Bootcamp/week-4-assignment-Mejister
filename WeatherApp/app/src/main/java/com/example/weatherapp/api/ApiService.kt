package com.example.weatherapp.api

import com.example.weatherapp.model.WeatherX
import com.example.weatherapp.model.model
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query



    interface ApiService {
        @GET("onecall")
        fun getWeatherInfo(
            @Query("lat")
            lat: String,
            @Query("lon")
            lon: String,
            @Query("exclude")
            exclude: String,
/*
            @Query("appid")
            appid: String,*/

            @Query("units")
            units: String="metrics",

        ): Call<WeatherX>
    }