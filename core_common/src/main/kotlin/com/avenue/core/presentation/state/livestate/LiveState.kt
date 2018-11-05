package com.avenue.core.presentation.state.livestate


class LiveState<S>(
    initialValue: S,
    val strategy: LiveStrategy = LiveStrategy.BEHAVIOR
): Observer<S>, UpdateProducer<S> {

    private var value: S = initialValue

    private val observers: LinkedHashSet<CancellableObserver<S>> = linkedSetOf()

    override fun observe(onChange: (S) -> Unit): Cancellable {
        val stateObserver = CancellableObserver(
            observer = onChange,
            onCancelled = ::onObserverCancelled
        )

        observers.add(stateObserver)

        if (strategy == LiveStrategy.BEHAVIOR) {
            onChange(value)
        }

        return stateObserver
    }

    override fun produce(value: S) {
        this.value = value
        observers.forEach {
            it.observer(value)
        }
    }

    override fun produce(update: S.() -> S) {
        value = value.update()
    }

    private fun onObserverCancelled(observer: (S) -> Unit) {
        observers
            .find { it == observer }
            ?.let { observers.remove(it) }
    }
}