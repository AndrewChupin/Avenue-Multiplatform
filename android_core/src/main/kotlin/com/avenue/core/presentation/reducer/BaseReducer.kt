package com.avenue.core.presentation.reducer

import android.arch.lifecycle.ViewModel
import com.avenue.core.extensions.CoroutinesExtensions
import com.avenue.core.presentation.state.State
import com.avenue.core.presentation.state.ViewState
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


actual abstract class BaseReducer<A : Action, S : State, VS : ViewState>
    : ViewModel(), Reducer<A, VS>, CoroutineScope, CoroutinesExtensions {

    actual abstract val state: S
    actual val job: Job = Job()

    actual override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job

    actual fun clear() {}

    override fun onCleared() {
        super.onCleared()
        clear()
        job.cancel()
    }
}