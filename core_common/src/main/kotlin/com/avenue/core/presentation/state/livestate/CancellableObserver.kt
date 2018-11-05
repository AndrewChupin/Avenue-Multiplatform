package com.avenue.core.presentation.state.livestate


internal data class CancellableObserver<S>(
    internal val observer: (S) -> Unit,
    private val onCancelled: ((S) -> Unit) -> Unit
): Cancellable {
    override fun cancel() = onCancelled(observer)
}