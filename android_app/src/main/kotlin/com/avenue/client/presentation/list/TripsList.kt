package com.avenue.client.presentation.list

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avenue.client.R
import com.avenue.project.data.trip.Trip


class TripsAdapter: RecyclerView.Adapter<TripViewHolder>() {

    var data: List<Trip> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): TripViewHolder {
        return TripViewHolder(
            LayoutInflater.from(p0.context).inflate(R.layout.item_trip_new, p0, false)
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(p0: TripViewHolder, p1: Int) {
        p0.bind(data[p1])
    }

}



class TripViewHolder(
    var view: View
): RecyclerView.ViewHolder(view) {

    lateinit var trip: Trip

    fun bind(trip: Trip) {

    }
}