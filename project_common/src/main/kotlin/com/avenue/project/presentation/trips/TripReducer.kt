package com.avenue.project.presentation.trips

import com.avenue.core.presentation.reducer.Action
import com.avenue.core.presentation.reducer.BaseReducer
import com.avenue.core.presentation.state.PrimaryViewState
import com.avenue.core.presentation.state.livestate.LiveState
import com.avenue.project.data.trip.TripDataSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async


sealed class TripsAction: Action {
    object LoadTrips: TripsAction()
}


class TripsReducer(
    private val TripsDataSource: TripDataSource
) : BaseReducer<TripsAction, TripsState, TripsViewState>() {

    override val state = TripsState()
    override val stateObserver = LiveState(TripsViewState())

    override fun reduce(action: TripsAction) = when(action) {
        is TripsAction.LoadTrips -> launchUi {
            stateObserver.produce(TripsViewState(PrimaryViewState.Loading, emptyList()))
            val trips = async(Dispatchers.Default) {
                TripsDataSource.getTrips()
            }
            stateObserver.produce(TripsViewState(PrimaryViewState.Data, trips.await()))
        }
    }
}