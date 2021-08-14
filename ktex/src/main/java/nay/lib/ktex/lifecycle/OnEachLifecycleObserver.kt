package nay.lib.ktex.lifecycle

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent

fun Lifecycle.addObserver(f: OnEachLifecycleObserver.() -> Unit) =
    addObserver(OnEachLifecycleObserver().apply(f))

/**
 * Lifecycle's Event Trigger Propagating LifecycleObserver.
 *
 * ```kotlin
 * this@MainActivity.lifecycle.addObserver {
 *     doOnStart { registerReceiver(receiver, IntentFilter(BROADCAST_DEFAULT_ALBUM_CHANGED)) }
 *     doOnStop { unregisterReceiver(receiver) }
 * }
 * ```
 */
class OnEachLifecycleObserver : LifecycleObserver {

    private var onCreateRunner: DoOnEachRunner? = null
    private var onResumeRunner: DoOnEachRunner? = null
    private var onStartRunner: DoOnEachRunner? = null
    private var onPauseRunner: DoOnEachRunner? = null
    private var onStopRunner: DoOnEachRunner? = null
    private var onDestroyRunner: DoOnEachRunner? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    fun onCreated() = onCreateRunner?.run()

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun onStarted() = onStartRunner?.run()

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    fun onResumed() = onResumeRunner?.run()

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    fun onPaused() = onPauseRunner?.run()

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun onStopped() = onStopRunner?.run()

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroyed() = onDestroyRunner?.run()


    fun doOnCreate(run: () -> Unit): OnEachLifecycleObserver {
        onCreateRunner = DoOnEachRunner(run)
        return this
    }
    fun doOnStart(run: () -> Unit): OnEachLifecycleObserver {
        onStartRunner = DoOnEachRunner(run)
        return this
    }
    fun doOnResume(run: () -> Unit): OnEachLifecycleObserver {
        onResumeRunner = DoOnEachRunner(run)
        return this
    }
    fun doOnPause(run: () -> Unit): OnEachLifecycleObserver {
        onPauseRunner = DoOnEachRunner(run)
        return this
    }
    fun doOnStop(run: () -> Unit): OnEachLifecycleObserver {
        onStopRunner = DoOnEachRunner(run)
        return this
    }
    fun doOnDestroy(run: () -> Unit): OnEachLifecycleObserver {
        onDestroyRunner = DoOnEachRunner(run)
        return this
    }


    inner class DoOnEachRunner(private val runner: () -> Unit) {
        fun run() = runner.invoke()
    }
}