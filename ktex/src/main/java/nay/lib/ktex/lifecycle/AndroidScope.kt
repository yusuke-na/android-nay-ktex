package nay.lib.ktex.lifecycle

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

object AndroidScope : CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main
}