package com.example.weatherapp.model

import com.google.gson.annotations.SerializedName


data class  WeatherX(
    @SerializedName("current")
    val current: Current?,
    @SerializedName("daily")
    val daily: List<Daily>?,
    @SerializedName("hourly")
    val hourly: List<Hourly>?,
    @SerializedName("lat")
    val lat: Double?,
    @SerializedName("lon")
    val lon: Double?,
    @SerializedName("timezone")
    val timezone: String?,
    @SerializedName("timezone_offset")
    val timezoneOffset: Int?
)