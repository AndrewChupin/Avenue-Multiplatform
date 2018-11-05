package com.avenue.project.presentation

import com.avenue.core.presentation.state.PrimaryViewState
import com.avenue.core.presentation.state.State
import com.avenue.core.presentation.state.ViewState


class TripState: State


class TripViewState(
    override val primaryState: PrimaryViewState = PrimaryViewState.Data
) : ViewState
