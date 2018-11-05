package com.avenue.core.presentation.state.livestate


interface Producer<S> {
    fun produce(value: S)
}

interface UpdateProducer<S>: Producer<S> {
    fun produce(update: S.() -> S)
}