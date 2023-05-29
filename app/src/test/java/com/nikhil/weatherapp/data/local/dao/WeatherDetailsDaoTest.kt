package com.nikhil.weatherapp.data.local.dao

import android.os.Build
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth
import com.nikhil.weatherapp.data.local.AppDatabase
import com.nikhil.weatherapp.util.generateCurrentWeatherEntity
import kotlinx.coroutines.runBlocking
import org.junit.*
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.P])
@RunWith(RobolectricTestRunner::class)

class WeatherDetailsDaoTest {

    @Rule
    @JvmField
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var weatherDatabase: AppDatabase
    private lateinit var currentWeatherDao: WeatherDetailsDao

    @Before
    fun setUp() {
        weatherDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            AppDatabase::class.java
        )
            .allowMainThreadQueries()
            .build()

        currentWeatherDao = weatherDatabase.getWeatherDao()
    }

    @After
    fun closeDatabase() {
        weatherDatabase.close()
    }




    @Test
    fun `empty database count must be zero`() {
        runBlocking {
        // When
        val count = currentWeatherDao.getCount()

        // Then
        Truth.assertThat(count).isEqualTo(0)
    }
    }

   @Test
   fun `insert one entity and count must be one`() {
       runBlocking {
        // When
        currentWeatherDao.addWeather(generateCurrentWeatherEntity("Istanbul", 1))

        // Then
        val count = currentWeatherDao.getCount()
        Truth.assertThat(count).isEqualTo(1)
    }
       }

 /*   @Test
    fun `insert one entity and test get function`() {
        // When
        currentWeatherDao.insertCurrentWeather(generateCurrentWeatherEntity("Istanbul", 1))

        // Then
        val entity = currentWeatherDao.getCurrentWeather().getOrAwaitValue()
        Truth.assertThat(entity.name).isEqualTo("Istanbul")
    }

    @Test
    fun `delete and insert a current weather`() {
        // When
        currentWeatherDao.deleteAndInsert(generateCurrentWeatherEntity("Istanbul", 1))
        val count = currentWeatherDao.getCount()
        Truth.assertThat(count).isEqualTo(1)

        // Then
        currentWeatherDao.deleteAndInsert(generateCurrentWeatherEntity("Adana", 2))
        val newCount = currentWeatherDao.getCount()
        val value = currentWeatherDao.getCurrentWeather().getOrAwaitValue()
        Truth.assertThat(newCount).isEqualTo(1)
        Truth.assertThat(value.name).isEqualTo("Adana")
    }

    @Test
    fun `first insert a current weather then delete and count must be zero`() {
        // When
        currentWeatherDao.deleteAndInsert(generateCurrentWeatherEntity("Istanbul", 1))
        val count = currentWeatherDao.getCount()
        Truth.assertThat(count).isEqualTo(1)

        // Then
        currentWeatherDao.deleteCurrentWeather()
        val newCount = currentWeatherDao.getCount()
        Truth.assertThat(newCount).isEqualTo(0)
    }*/
}
