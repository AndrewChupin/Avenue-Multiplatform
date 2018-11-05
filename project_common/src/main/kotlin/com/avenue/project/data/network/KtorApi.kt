package com.avenue.project.data.network


import io.ktor.client.HttpClient


class KtorApi(
    private val client: HttpClient
) {

   /* override suspend fun loadTrips(tripRequests: TripRequests): Deferred<List<TripDto>> {
        return client.get<String>(Request.LOAD_TRIPS)
    }*/

    suspend fun hello() {

    }
}