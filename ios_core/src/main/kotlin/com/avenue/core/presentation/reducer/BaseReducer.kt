/*
package com.avenue.core.presentation.reducer

import com.avenue.core.extensions.CoroutinesExtensions
import com.avenue.core.presentation.state.State
import com.avenue.core.presentation.state.ViewState

actual abstract class BaseReducer<A: Action, S: State, VS: ViewState>() : Reducer<A, VS>, CoroutineScope,
    CoroutinesExtensions {

    abstract val state: S

    override val coroutineContext: CoroutineContext

    val job: Job

    fun clear()
}*/
