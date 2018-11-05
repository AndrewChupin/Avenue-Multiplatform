package com.avenue.client.presentation.trips

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import android.view.View
import com.avenue.client.R
import com.avenue.client.presentation.list.TripsAdapter
import com.avenue.core.presentation.reducer.ReducerBuilder
import com.avenue.core.presentation.screen.ToolbarConfig
import com.avenue.core.presentation.screen.ToolbarScreen
import com.avenue.core.presentation.state.PrimaryViewState
import com.avenue.core.presentation.view.RenderableBaseFragment
import com.avenue.project.presentation.trips.TripsAction
import com.avenue.project.presentation.trips.TripsViewState
import kotlinx.android.synthetic.main.fragment_trips.*
import kotlinx.android.synthetic.main.toolbar.*


class TripsFragment : RenderableBaseFragment<TripsAction, TripsViewState>(), ToolbarScreen {

    companion object {
        fun newInstance() = TripsFragment()
    }

    override val layoutId: Int = R.layout.fragment_trips
    override val reducerBuilder: ReducerBuilder<TripsAction, TripsViewState> = TripsReducerBuilder()
    private var tripAdapter: TripsAdapter  = TripsAdapter()

    override fun onViewCreatedBeforeRender(savedInstanceState: Bundle?) {
        setupToolbarWith(requireActivity(), ToolbarConfig(
            title = "Поездки",
            isDisplayHomeButton = false,
            isEnableHomeButton = false
        ))

        trips_list.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = tripAdapter
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        reducer.reduce(TripsAction.LoadTrips)
    }

    override fun render(state: TripsViewState) {
        if (state.primaryState == PrimaryViewState.Data) {
            tripAdapter.data = state.trips
        }
    }

    override fun getToolbar(): Toolbar = toolbar
}