/*
 * Created by Naaatan on 2021/09/04 17:45
 * Copyright (c) 2021 . All rights reserved.
 * Last modified 2021/08/14 15:19
 */

package nay.lib.ktex.lifecycle

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent

fun broadcastReceiver(f: OnEachBroadcastReceiver.(Context?, Intent?) -> Unit): BroadcastReceiver =
    OnEachBroadcastReceiver().apply {
        doOnReceive { context, intent -> this.f(context, intent) }
    }

/**
 * Create a BroadcastReceiver easily.
 *
 * ```kotlin
 * val receiver = broadcastReceiver { context, intent ->
 *     when (intent?.action) {
 *         BROADCAST_DEFAULT_ALBUM_CHANGED -> handleAlbumChanged()
 *         BROADCAST_CHANGE_TYPE_CHANGED -> handleChangeTypeChanged()
 *     }
 * }
 */
class OnEachBroadcastReceiver : BroadcastReceiver() {
    private var onReceiveRunner: OnReceiveRunner? = null

    override fun onReceive(context: Context?, intent: Intent?) {
        onReceiveRunner?.run(context, intent)
    }

    inner class OnReceiveRunner(private val runner: (Context?, Intent?) -> Unit) {
        fun run(ctx: Context?, intent: Intent?) = runner.invoke(ctx, intent)
    }

    fun doOnReceive(run: (Context?, Intent?) -> Unit) {
        onReceiveRunner = OnReceiveRunner(run)
    }
}