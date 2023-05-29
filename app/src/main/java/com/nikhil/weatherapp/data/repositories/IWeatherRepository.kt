package com.nikhil.weatherapp.data.repositories

import com.nikhil.weatherapp.data.model.CityWeather
import com.nikhil.weatherapp.data.model.WeatherDetail

interface IWeatherRepository {
    suspend fun findCityWeather(cityName: String): CityWeather

    suspend fun addWeather(weatherDetail: WeatherDetail)

    suspend fun fetchWeatherDetail(cityName: String): WeatherDetail?

    suspend fun fetchAllWeatherDetails(): List<WeatherDetail>
}