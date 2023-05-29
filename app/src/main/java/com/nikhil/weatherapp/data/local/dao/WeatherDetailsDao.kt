package com.nikhil.weatherapp.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.nikhil.weatherapp.data.model.WeatherDetail

@Dao
interface WeatherDetailsDao {

    /**
     * Duplicate values are replaced in the table.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addWeather(weatherDetail: WeatherDetail)

    @Query("SELECT * FROM ${WeatherDetail.TABLE_NAME} WHERE cityName = :cityName")
    suspend fun fetchWeatherByCity(cityName: String): WeatherDetail?

    @Query("SELECT * FROM ${WeatherDetail.TABLE_NAME}")
    suspend fun fetchAllWeatherDetails(): List<WeatherDetail>


    @Query("Select count(*) from ${WeatherDetail.TABLE_NAME}")
    suspend fun getCount(): Int

}
