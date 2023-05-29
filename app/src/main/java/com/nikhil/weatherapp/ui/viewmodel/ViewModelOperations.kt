package com.nikhil.weatherapp.ui.viewmodel

interface ViewModelOperations {
    fun findCityWeather(cityName: String)
    fun fetchWeatherDetailFromDb(cityName: String)
    fun fetchAllWeatherDetailsFromDb()
}