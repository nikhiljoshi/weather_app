package com.nikhil.weatherapp

import android.app.Application
import com.nikhil.weatherapp.modules.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class WeatherApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin{
            androidContext(this@WeatherApplication)
            modules(appModule)
        }
    }
}
