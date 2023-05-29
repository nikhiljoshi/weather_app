package com.nikhil.weatherapp.data.repositories

import com.nikhil.weatherapp.data.local.AppDatabase
import com.nikhil.weatherapp.data.model.CityWeather
import com.nikhil.weatherapp.data.model.WeatherDetail
import com.nikhil.weatherapp.data.network.RestAPI
import com.nikhil.weatherapp.data.network.SafeApiRequest

class WeatherRepositoryImpl(
    private val restAPI: RestAPI,
    private val appDatabase: AppDatabase
) : SafeApiRequest(), IWeatherRepository {

    override suspend fun findCityWeather(cityName: String): CityWeather = apiRequest {
        restAPI.findCityWeatherData(cityName)
    }

    override suspend fun addWeather(weatherDetail: WeatherDetail) {
        appDatabase.getWeatherDao().addWeather(weatherDetail)
    }

    override suspend fun fetchWeatherDetail(cityName: String): WeatherDetail? =
        appDatabase.getWeatherDao().fetchWeatherByCity(cityName)

    override suspend fun fetchAllWeatherDetails(): List<WeatherDetail> =
        appDatabase.getWeatherDao().fetchAllWeatherDetails()
}
