package com.avenue.core.presentation.reducer

import com.avenue.core.extensions.SuspendExtensions
import com.avenue.core.presentation.state.State
import com.avenue.core.presentation.state.ViewState
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


expect abstract class BaseReducer<A: Action, S: State, VS: ViewState>() : Reducer<A, VS>, SuspendExtensions {

    abstract val state: S

    override val coroutineContext: CoroutineContext

    val job: Job

    abstract fun clear()
}