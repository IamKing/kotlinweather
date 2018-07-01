package com.curious.kotlinweather.domain.commands

import com.curious.kotlinweather.ForecastRequest
import com.curious.kotlinweather.domain.datasource.ForecastDataMapper
import com.curious.kotlinweather.domain.model.ForecastList

class RequestForecastCommand(private val zipCode:String):
        Command<ForecastList>{

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }



}