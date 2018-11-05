package com.avenue.core.presentation.view

import com.avenue.core.presentation.reducer.Action
import com.avenue.core.presentation.reducer.Reducer
import com.avenue.core.presentation.state.ViewState


/**
* This interface mean that object using controller as [BaseViewModel]
* </br>
* @author Andrew Chupin
*/
interface RenderableView<R: Reducer<A, VS>, A: Action, VS: ViewState>: Renderable<VS> {
    /**
     * [BaseViewModel] which you can provide with [javax.inject.Inject] annotation
     */
    var reducer: R
}