package com.nikhil.weatherapp.ui.viewmodelfactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.nikhil.weatherapp.data.repositories.WeatherRepositoryImpl
import com.nikhil.weatherapp.ui.viewmodel.WeatherViewModel

@Suppress("UNCHECKED_CAST")
class WeatherViewModelFactory(
    private val repository: WeatherRepositoryImpl
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherViewModel(repository) as T
    }
}
