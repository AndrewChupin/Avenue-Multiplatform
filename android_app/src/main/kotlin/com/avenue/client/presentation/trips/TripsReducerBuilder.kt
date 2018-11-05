package com.avenue.client.presentation.trips

import com.avenue.core.presentation.reducer.Reducer
import com.avenue.core.presentation.reducer.ReducerBuilder
import com.avenue.project.data.network.KtorApi
import com.avenue.project.data.trip.TripDataSourceDefault
import com.avenue.project.presentation.trips.TripsAction
import com.avenue.project.presentation.trips.TripsReducer
import com.avenue.project.presentation.trips.TripsViewState
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android


class TripsReducerBuilder : ReducerBuilder<TripsAction, TripsViewState> {
    override fun build(): Reducer<TripsAction, TripsViewState> {
        return TripsReducer(
            TripDataSourceDefault(
                KtorApi(
                    HttpClient(Android)
                )
            )
        )
    }
}