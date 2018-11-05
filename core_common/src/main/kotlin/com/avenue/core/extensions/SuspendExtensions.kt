package com.avenue.core.extensions

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

interface SuspendExtensions: CoroutineScope {

    fun launchUi(block: suspend () -> Unit) {
        launch(coroutineContext) {
            block()
        }
    }

    fun launchUi(onTry: suspend () -> Unit,
                 onCache: suspend (Throwable) -> Unit = {},
                 onFinally: suspend () -> Unit = {}) {
        launch(coroutineContext) {
            try {
                onTry()
            } catch (e: Exception) {
                onCache(e)
            } finally {
                onFinally()
            }
        }
    }
}