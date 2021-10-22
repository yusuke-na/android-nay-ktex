/*
 * Created by Naaatan on 2021/09/04 17:52
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/09/04 17:52
 */

package nay.lib.ktex

import android.graphics.Point
import android.view.View

fun View.getLocationPointInWindow(): Point {
    val array = IntArray(2)
    this.getLocationInWindow(array)
    return Point(array[0], array[1])
}

fun View.getLocationPointOnScreen(): Point {
    val array = IntArray(2)
    this.getLocationOnScreen(array)
    return Point(array[0], array[1])
}