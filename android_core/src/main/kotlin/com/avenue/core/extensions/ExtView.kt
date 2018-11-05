package com.avenue.core.extensions

import android.view.View


@Suppress("RecursivePropertyAccessor")
var View.isVisible: Boolean
	get() = visibility == View.VISIBLE
	set(value) {
		visibility = if (value) View.VISIBLE else View.GONE
	}
