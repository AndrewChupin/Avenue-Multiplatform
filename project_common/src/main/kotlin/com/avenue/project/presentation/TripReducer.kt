package com.avenue.project.presentation

import com.avenue.core.presentation.reducer.Action
import com.avenue.core.presentation.reducer.BaseReducer
import com.avenue.core.presentation.state.livestate.Observer


class TripAction: Action


class TripReducer(
    override val state: TripState,
    override val stateObserver: Observer<TripViewState>
) : BaseReducer<TripAction, TripState, TripViewState>() {

    override fun reduce(action: TripAction) {

    }

    override fun clear() {

    }
}