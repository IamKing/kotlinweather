package com.curious.kotlinweather.domain.datasource

import com.curious.kotlinweather.domain.model.Forecast
import com.curious.kotlinweather.domain.model.ForecastList

interface ForecastDataSource{
    fun requestForecastByZipCode(zipCode: Long, date: Long): ForecastList?

    fun requestDayForecast(id: Long): Forecast?
}