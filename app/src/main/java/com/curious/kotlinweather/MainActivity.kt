package com.curious.kotlinweather

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import com.curious.kotlinweather.domain.commands.RequestForecastCommand
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.custom.async
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread

class MainActivity : AppCompatActivity() {


    var mAdapter: ForecastListAdapter? = null;
    var dataList: List<String> = ArrayList<String>();
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        forecast_list.layoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        forecast_list.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL))

        async() {
            val result = RequestForecastCommand("94043").execute()
            println()


            uiThread {
                forecast_list.adapter = ForecastListAdapter(result) {
                    toast(it.date)
                };
            }
        }
    }


}
