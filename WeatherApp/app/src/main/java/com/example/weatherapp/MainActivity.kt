package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.weatherapp.api.ApiClient
import com.example.weatherapp.model.model
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getEverything()
    }

    private fun getEverything() {
        ApiClient.getApiService().getWeatherInfo("40.14", "26.40", "minutely").enqueue(object :
            Callback<model> {
            override fun onResponse(call: Call<model>, response: Response<model>) {
                Log.d("deneme1", response.body().toString())

                if (response.isSuccessful) {
                    val everything = response.body()
                    everything?.let {
                        // Log.d("deneme1", it.articles?.size.toString())
                    }
                }
            }

            override fun onFailure(call: Call<model>, t: Throwable) {
                Log.d("deneme1", t.toString())

            }
        })
    }
}
