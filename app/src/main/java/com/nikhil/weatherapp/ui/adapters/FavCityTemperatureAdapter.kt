package com.nikhil.weatherapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nikhil.weatherapp.R
import com.nikhil.weatherapp.data.model.WeatherDetail
import com.nikhil.weatherapp.databinding.ListItemCityBinding
import com.nikhil.weatherapp.util.AppConstants
import com.nikhil.weatherapp.util.AppUtils
import java.util.*

class FavCityTemperatureAdapter :
    RecyclerView.Adapter<FavCityTemperatureAdapter.ViewHolder>() {

    private val weatherDetailList = ArrayList<WeatherDetail>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding: ListItemCityBinding = DataBindingUtil.inflate(
            LayoutInflater.from(parent.context),
            R.layout.list_item_city,
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(weatherDetailList[position])
    }

    override fun getItemCount(): Int = weatherDetailList.size

    fun setData(
        newWeatherDetail: List<WeatherDetail>
    ) {
        weatherDetailList.clear()
        weatherDetailList.addAll(newWeatherDetail)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ListItemCityBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindItems(weatherDetail: WeatherDetail) {
            binding.apply {
                val iconCode = weatherDetail.icon?.replace("n", "d")
                AppUtils.setGlideImage(
                    imageWeatherSymbol,
                    AppConstants.IMAGE_ENDPOINT + "${iconCode}@4x.png"
                )
                textCityName.text =
                    "${weatherDetail.cityName?.capitalize()}, ${weatherDetail.countryName}"
                textTemperature.text = weatherDetail.temp.toString()
                textDateTime.text = weatherDetail.dateTime
            }
        }
    }
}
