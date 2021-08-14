# android-nay-ktex
android kotlin extensions.

## LiveEvent
One Shot LiveData. Notified to the observer when calling a `call` method.

## LifecycleScopeSupport
easily create lifecycleScope.

## OnEachLifecycleObserver
Lifecycle's Event Trigger Propagating LifecycleObserver.

```kotlin
this@MainActivity.lifecycle.addObserver {
    doOnStart { registerReceiver(receiver, IntentFilter(BROADCAST_DEFAULT_ALBUM_CHANGED)) }
    doOnStop { unregisterReceiver(receiver) }
}
```

## OnEachBroadcastReceiver
Create a BroadcastReceiver easily.

 ```kotlin
 val receiver = broadcastReceiver { context, intent ->
     when (intent?.action) {
         BROADCAST_DEFAULT_ALBUM_CHANGED -> handleAlbumChanged()
         BROADCAST_CHANGE_TYPE_CHANGED -> handleChangeTypeChanged()
     }
 }
 ```

## ByteArray Extension
byte Array to Hex String, to Int, toLong ext..
