package com.example.weatherapp.adapter


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weatherapp.databinding.FragmentDetailBinding
import com.example.weatherapp.model.Daily
import com.example.weatherapp.ui.DetailFragment
import com.squareup.picasso.Picasso

class WeatherAdapter : ListAdapter<Daily, WeatherAdapter.WeatherViewHolder>(WeatherDiffUtil()) {

    class WeatherViewHolder(private val itemWeatherCardBinding: FragmentDetailBinding) :
        RecyclerView.ViewHolder(itemWeatherCardBinding.root) {
        fun bind(daily: Daily) {
            itemWeatherCardBinding.apply {

                tvName.text = daily.weather?.get(0)?.id.toString()
                tvTempMax.text = daily.maxTempText
                tvTempMin.text  = daily.minTempText

                Picasso.get().load(daily.weatherImageUrl).into(ivWeather);

            }




        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemWeatherCardBinding = FragmentDetailBinding.inflate(LayoutInflater.from(parent.context))
        return WeatherViewHolder(itemWeatherCardBinding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

    class WeatherDiffUtil : DiffUtil.ItemCallback<Daily>() {
        override fun areItemsTheSame(oldItem: Daily, newItem: Daily): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: Daily, newItem: Daily): Boolean {
            return oldItem == newItem
        }

    }
}