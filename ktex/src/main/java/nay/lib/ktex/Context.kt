/*
 * Created by Naaatan on 2021/09/04 17:48
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/09/04 17:48
 */

package nay.lib.ktex

import android.content.Context
import android.widget.Toast


fun Context.toast(message: String, duration: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, duration).show()
}

fun Context.convertDp2Px(dp: Float): Float {
    val metrics = resources.displayMetrics
    return dp * metrics.density
}

fun convertPx2Dp(px: Int, context: Context): Float {
    val metrics = context.resources.displayMetrics
    return px / metrics.density
}