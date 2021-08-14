package nay.lib.ktex.legacy

import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow

open class Notifier<T>(initValue: T) {
    private val listeners: MutableList<OnChangedListener<T>> = mutableListOf()

    var value: T = initValue
        private set(value) {
            field = value
            notifyOnChanged(value)
        }

    fun update(value: T) {
        this.value = value
    }

    fun addOnChangedListener(listener: OnChangedListener<T>) {
        listeners.add(listener)
    }

    fun removeOnChangedListener(listener: OnChangedListener<T>) {
        listeners.remove(listener)
    }

    private fun notifyOnChanged(value: T) {
        listeners.forEach { listener -> listener.onChanged(value) }
    }

    @ExperimentalCoroutinesApi
    fun asCallbackFlow(): Flow<T> = callbackFlow {
        // リスナー生成に失敗した場合は close を呼び出して Flow を終了させる
        val hasError = false
        if (hasError) {
            close()
        }

        // callbackFlow で作成した Flow にデータ更新を通知するリスナーを作成する
        val listener = object : OnChangedListener<T> {
            override fun onChanged(value: T) {
                offer(value)
            }
        }

        // callbackFlow で作成した Flow にデータ更新を通知するリスナーを登録する
        addOnChangedListener(listener)

        // callbackFlow で作成した Flow がキャンセルされるまで待ち、キャンセルされたらリスナーを解除する
        awaitClose {
            removeOnChangedListener(listener)
        }
    }



    interface OnChangedListener<in T> {
        fun onChanged(value: T)
    }
}