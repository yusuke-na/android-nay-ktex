/*
 * Created by Naaatan on 2021/09/04 17:45
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/08/12 13:36
 */

package nay.lib.ktex.lifecycle

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.CoroutineStart

interface LifecycleScopeSupport {

    val scope: LifecycleScope

    fun launch(
        start: CoroutineStart = CoroutineStart.DEFAULT,
        block: suspend CoroutineScope.() -> Unit
    ) = scope.bindLaunch(start, block)
}