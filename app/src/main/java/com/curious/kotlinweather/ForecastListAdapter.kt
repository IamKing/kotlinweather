package com.curious.kotlinweather

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.curious.kotlinweather.domain.model.Forecast
import com.curious.kotlinweather.domain.model.ForecastList
import com.curious.kotlinweather.extentions.ctx
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_forecast.view.*

class ForecastListAdapter(val data: ForecastList,
                          val itemClick: (Forecast) -> Unit)
    : RecyclerView.Adapter<ForecastListAdapter.Holder>() {

    override fun onCreateViewHolder(parent: ViewGroup, postition: Int): ForecastListAdapter.Holder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_forecast, parent, false)
        return Holder(view, itemClick);
    }

    override fun getItemCount(): Int = data.dailyForecast.size

    override fun onBindViewHolder(holder: ForecastListAdapter.Holder, position: Int) {
        holder.bindForecast(data.dailyForecast[position])
    }

    class Holder(val view: View, val itemClick: (Forecast) -> Unit)
        : RecyclerView.ViewHolder(view) {

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(view.ctx).load(iconUrl).into(view.iconImg)
                view.dateText.text = date
                view.descriptionText.text = description
                view.maxTemperature.text = "${high.toString()}℃"
                view.minTemperature.text = "${low.toString()}℃"
                view.setOnClickListener { itemClick(forecast) }
            }
        }
    }
}