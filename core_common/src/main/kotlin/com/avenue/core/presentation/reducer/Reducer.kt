package com.avenue.core.presentation.reducer

import com.avenue.core.presentation.state.ViewState
import com.avenue.core.presentation.state.livestate.Observer


interface Reducer<A: Action, S: ViewState> {
    val stateObserver: Observer<S>
    fun reduce(action: A)
}
