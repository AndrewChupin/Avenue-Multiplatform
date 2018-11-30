package com.avenue.client.presentation.main

import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.View
import com.avenue.client.R
import com.avenue.core.presentation.screen.ToolbarConfig
import com.avenue.core.presentation.screen.ToolbarScreen
import com.avenue.core.presentation.view.BaseFragment
import kotlinx.android.synthetic.main.collapse_toolbar.*


class MainFragment: BaseFragment(), ToolbarScreen {

    companion object {
        fun newInstance() = MainFragment()
    }

    override val layoutId: Int = R.layout.fragment_main


    override fun getToolbar(): Toolbar = toolbar

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupToolbarWith(requireActivity(), ToolbarConfig(
            title = "Avenue",
            isDisplayHomeButton = false,
            isEnableHomeButton = false
        ))
    }

}