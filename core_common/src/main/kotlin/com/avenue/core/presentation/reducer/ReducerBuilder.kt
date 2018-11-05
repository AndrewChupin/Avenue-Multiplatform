package com.avenue.core.presentation.reducer

import com.avenue.core.presentation.state.ViewState


interface ReducerBuilder<A: Action, VS: ViewState> {
    fun build(): Reducer<A, VS>
}
