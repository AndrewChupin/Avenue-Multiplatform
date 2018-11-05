package com.avenue.core.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

interface CoroutinesExtensions {

    fun CoroutineScope.launchUi(block: suspend () -> Unit) {
        launch(coroutineContext) {
            block()
        }
    }

    fun CoroutineScope.launchUi(
        block: suspend () -> Unit,
        onError: suspend (Throwable) -> Unit = {},
        onFinally: suspend () -> Unit = {}
    ) {
        launch(coroutineContext) {
            try {
                block()
            } catch (e: Exception) {
                onError(e)
            } finally {
                onFinally()
            }
        }
    }
}