package com.avenue.project.data.network

import com.avenue.project.data.trip.GetAllTripRequests
import com.avenue.project.data.trip.TripDto

interface Api {
    suspend fun loadTrips(tripRequests: GetAllTripRequests): List<TripDto>
}