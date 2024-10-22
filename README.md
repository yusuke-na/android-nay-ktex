# android-nay-ktex
[![](https://jitpack.io/v/Naaatan/android-nay-ktex.svg)](https://jitpack.io/#Naaatan/android-nay-ktex)

android kotlin extensions.

## Setup

Step 1. Add Jitpack repository to your project **build.gradle**
```groovy
allprojects {
    repositories {
        ...
        maven { url 'https://jitpack.io' }
    }
}
```

Step 2. Add dependency to your app **build.gradle**
```groovy
dependencies {
    implementation 'com.github.yusuke-na:android-nay-ktex:1.0.0'
}
```


## LiveEvent
One Shot LiveData. Notified to the observer when calling a `call` method.

```kotlin
val showEvent =  LiveEvent<Boolean>()

fun callShowEvent(isShow: Boolean) {
    showEvent.call(isShow)
}
```

Activity and Fragment create Observer with this LiveEvent tag.

```kotlin
viewModel.showEvent.observe(this, "tag") { isShow ->
    // add your code.
}
```

## LifecycleScopeSupport
Create a lifecycleScope easily.

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

## Util
- NonNullCheck functions
- TimerUtil (ex.. Format timeInMillis to 'HH:mm:ss' or 'HH:mm:ss.SSS'.

## Extension
- ByteArray
- Collection
- Context
- Double
- Float
- Int
- Short
- String
- Uri
- View
