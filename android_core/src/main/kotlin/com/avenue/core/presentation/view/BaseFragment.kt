package com.avenue.core.presentation.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.support.annotation.CallSuper
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.avenue.core.presentation.reducer.Action
import com.avenue.core.presentation.reducer.Reducer
import com.avenue.core.presentation.reducer.ReducerBuilder
import com.avenue.core.presentation.state.ViewState
import com.avenue.core.presentation.state.livestate.Cancellable
import com.makecity.core.presentation.navigation.ActivityActionDelegate
import kotlinx.android.synthetic.*


abstract class BaseFragment: Fragment(), ActivityActionDelegate {

    abstract val layoutId: Int

    @CallSuper
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(layoutId, container, false)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity is ActivityActionHolder) {
            (activity as ActivityActionHolder).delegate = this
        }
    }

    @CallSuper
    override fun onDestroyView() {
        super.onDestroyView()
        if (activity is ActivityActionHolder) {
            (activity as ActivityActionHolder).delegate = null
        }
        clearFindViewByIdCache()
    }

    override fun onBackClick(): Boolean {
        return false
    }

    override fun onScreenResult(requestCode: Int, resultCode: Int, data: Intent?) {}

    protected fun showMessage(message: String, contextView: View? = view) {
        contextView?.let {
            Snackbar.make(it, message, Snackbar.LENGTH_LONG).show()
        }
    }

    @Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
    protected inline fun <reified Data: Parcelable> getArgument(key: String): Data {
        arguments?.let {
            if (it.containsKey(key)) {
                return it.getParcelable(key)
            }
        }
        throw IllegalStateException("Not found data with key $key")
    }
}


abstract class RenderableBaseFragment<A: Action, VS: ViewState>: BaseFragment(), RenderableView<A, VS> {

    abstract val reducerBuilder: ReducerBuilder<A, VS>
    override lateinit var reducer: Reducer<A, VS>
    private lateinit var cancellable: Cancellable

    abstract fun onViewCreatedBeforeRender(savedInstanceState: Bundle?)

    @CallSuper
    override fun onAttach(context: Context?) {
        reducer = reducerBuilder.build()
        super.onAttach(context)
    }

    @CallSuper
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        onViewCreatedBeforeRender(savedInstanceState)
        cancellable = reducer.stateObserver.observe {
            render(it)
        }
    }

    infix fun View?.clickReduce(action: A) {
        this?.setOnClickListener {
            reducer.reduce(action)
        }
    }

    infix fun View?.clickReduce(action: () -> A) {
        this?.setOnClickListener {
            reducer.reduce(action())
        }
    }

    @CallSuper
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        cancellable.cancel()
    }
}
