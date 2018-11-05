package com.avenue.core.presentation.reducer

import com.avenue.core.presentation.state.ViewState


interface ReducerBuilder<A: Action, VS: ViewState> {
    fun <R> build(): R where R: Reducer<A, VS>
}
