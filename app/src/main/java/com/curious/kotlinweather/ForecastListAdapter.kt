package com.curious.kotlinweather

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.curious.kotlinweather.domain.model.Forecast
import com.curious.kotlinweather.domain.model.ForecastList
import com.curious.kotlinweather.extentions.ctx
import com.squareup.picasso.Picasso

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
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.findViewById(R.id.iconImg)
            dateView = view.findViewById(R.id.dateText)
            descriptionView = view.findViewById(R.id.descriptionText)
            maxTemperatureView = view.findViewById(R.id.maxTemperature)
            minTemperatureView = view.findViewById(R.id.minTemperature)
        }

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()}℃"
                minTemperatureView.text = "${low.toString()}℃"
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }
    }
}