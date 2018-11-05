package com.avenue.core.presentation.state.livestate

interface Observer<S> {

    fun observe(onChange: (S) -> Unit): Cancellable

}