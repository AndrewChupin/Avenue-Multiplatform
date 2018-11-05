package com.avenue.core.presentation.view

import com.avenue.core.presentation.state.ViewState


/**
 * This interface mean that screen support single valueOrInitial
 * You can use it with [BaseReducer]
 * [ViewState] and [BaseFragment]
 */
interface Renderable<in VS: ViewState> {
    /**
     * This function must be refresh all screen valueOrInitial
     */
    fun render(state: VS)
}