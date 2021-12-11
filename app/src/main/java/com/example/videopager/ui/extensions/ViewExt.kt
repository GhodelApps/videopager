package com.example.videopager.ui.extensions

import android.view.View
import android.view.ViewManager

fun View.detachFromParent() {
    val parent = parent as? ViewManager ?: return
    parent.removeView(this)
}