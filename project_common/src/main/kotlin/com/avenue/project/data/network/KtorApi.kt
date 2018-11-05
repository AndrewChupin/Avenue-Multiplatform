package com.avenue.project.data.network


import com.avenue.project.data.trip.GetAllTripRequests
import com.avenue.project.data.trip.TripDto
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


class KtorApi(
    private val client: HttpClient
) : Api {

    override suspend fun loadTrips(tripRequests: GetAllTripRequests): List<TripDto> {
        val a = GlobalScope.async(Dispatchers.Default) { client.get<String>(
            host = AvenueHttp.HOST,
            port = AvenueHttp.PORT,
            path = AvenueHttp.Requests.LOAD_TRIPS
        )}

        println("Logos ${a.await()}")

        return listOf(TripDto(1), TripDto(2))
    }
}