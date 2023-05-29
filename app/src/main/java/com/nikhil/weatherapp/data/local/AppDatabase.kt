package com.nikhil.weatherapp.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.nikhil.weatherapp.data.local.dao.WeatherDetailsDao
import com.nikhil.weatherapp.data.model.WeatherDetail

@Database(
    entities = [WeatherDetail::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun getWeatherDao(): WeatherDetailsDao

    companion object {
        const val DB_NAME = "weather_database"

        @Volatile
        private var INSTANCE: AppDatabase? = null

        operator fun invoke(context: Context) = INSTANCE ?: synchronized(this) {
            INSTANCE ?: buildDatabase(context).also {
                INSTANCE = it
            }
        }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java,
                DB_NAME
            ).build()
    }
}
