package com.avenue.project.presentation.trips

import com.avenue.core.presentation.state.PrimaryViewState
import com.avenue.core.presentation.state.State
import com.avenue.core.presentation.state.ViewState
import com.avenue.project.data.trip.Trip


class TripsState: State


data class TripsViewState(
    override val primaryState: PrimaryViewState = PrimaryViewState.Data,
    val trips: List<Trip> = emptyList()
) : ViewState
