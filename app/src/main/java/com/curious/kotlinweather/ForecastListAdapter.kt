package com.curious.kotlinweather

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import com.curious.kotlinweather.domain.model.ForecastList

class ForecastListAdapter(val data: ForecastList) : RecyclerView.Adapter<ForecastListAdapter.Holder>() {


    override fun onCreateViewHolder(parent: ViewGroup, postition: Int): ForecastListAdapter.Holder {
        val view: TextView = LayoutInflater.from(parent.context).inflate(android.R.layout.simple_list_item_1, parent, false) as TextView
        return Holder(view);
    }

    override fun getItemCount(): Int = data.dailyForecast.size

    override fun onBindViewHolder(holder: ForecastListAdapter.Holder, position: Int) {
        with(data.dailyForecast[position]) {
            holder.view.text = "$date - $description - $high/$low"
        }
    }

    class Holder(val view: TextView) : RecyclerView.ViewHolder(view) {
    }

}