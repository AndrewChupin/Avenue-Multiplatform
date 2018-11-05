package com.avenue.project.data.trip

import com.avenue.project.data.network.Api

interface TripDataSource {
    suspend fun getTrips(): List<Trip>
}


class TripDataSourceDefault(
    private val api: Api
): TripDataSource {

    override suspend fun getTrips(): List<Trip> {
        return api.loadTrips(GetAllTripRequests(0.0, 0.0))
            .map {
                it.run { Trip(id) }
            }
    }
}