package com.nikhil.weatherapp.modules

import com.nikhil.weatherapp.data.local.AppDatabase
import com.nikhil.weatherapp.data.network.NetworkConnectionInterceptor
import com.nikhil.weatherapp.data.network.RestAPI
import com.nikhil.weatherapp.data.repositories.WeatherRepositoryImpl
import com.nikhil.weatherapp.ui.viewmodelfactory.WeatherViewModelFactory
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val appModule = module {
    single {  WeatherRepositoryImpl(get(),get()) }
    single {  NetworkConnectionInterceptor(androidContext()) }
    single {  AppDatabase(get()) }
    single {  WeatherViewModelFactory(get()) }
    single {  RestAPI(get()) }
}