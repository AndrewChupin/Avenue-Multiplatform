package com.avenue.project.data.network

import com.avenue.project.data.trip.TripDto
import com.avenue.project.data.trip.TripRequests
import kotlinx.coroutines.Deferred

interface Api {
    suspend fun loadTrips(tripRequests: TripRequests): Deferred<List<TripDto>>
}