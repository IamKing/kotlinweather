package com.curious.kotlinweather

import android.app.Application
import com.curious.kotlinweather.extentions.DelegatesExt
import kotlin.properties.Delegates

class App : Application() {
    companion object {
        //notNull如果在被赋值之前访问会抛出异常
        var instance: App by DelegatesExt.notNullSingleValue<App>()
    }

    override fun onCreate() {
        super.onCreate()
        instance = this;
    }


}