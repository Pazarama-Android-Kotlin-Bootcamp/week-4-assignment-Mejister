package com.example.weatherapp.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.weatherapp.adapter.WeatherAdapter
import com.example.weatherapp.api.ApiClient
import com.example.weatherapp.databinding.FragmentDetailBinding
import com.example.weatherapp.model.WeatherX
import com.example.weatherapp.model.model
import retrofit2.Call
import retrofit2.Callback

import retrofit2.Response

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getDailyWeather()
    }


    private fun getDailyWeather() {
        ApiClient.getApiService().getWeatherInfo("40.78","30.40","metric").enqueue(object:
            Callback<WeatherX> {
            override fun onResponse(call: Call<WeatherX>, response: Response<WeatherX>) {
                Log.d("WeatherFragment", response.body().toString())

                if (response.isSuccessful) {
                    val weather = response.body()
                    weather?.let {
                        binding.rvWeather.WeatherAdapter = WeatherAdapter().apply {
                            submitList(it.daily)
                        }
                        Log.d("WeatherFragment", it.daily?.get(0)?.weather?.get(0)?.description.toString())
                    }
                }
            }

            override fun onFailure(call: Call<WeatherX>, t: Throwable) {
                Log.d("WeatherFragment", t.toString())
            }
        })
    }





    override fun onDestroyView() {
        super.onDestroyView()
        _binding= null
    }

}