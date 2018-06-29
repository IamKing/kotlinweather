package com.curious.kotlinweather

import com.google.gson.Gson
import java.net.URL

/**
 * 请求数据
 */
public class ForecastRequest(val zipcode: String) {
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce";
        private val URL_T = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7";
        private val COMPLETE_URL = "$URL_T&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipcode).readText()
        println("forecastJsonStr====" + forecastJsonStr)
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }

}