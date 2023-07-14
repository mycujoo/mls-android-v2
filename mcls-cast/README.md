# MCLSCast

MCLSCast is used to connect to our Google Cast receiver app.

## Installation

you can import the player using in your app (or feature) module add this one to your dependencies

```groovy
dependencies {
    // ... Other imports 

    def latestVersion = "1.0.0" // Use the latest version
    implementation "tv.mycujoo.mcls:mcls-cast:$latestVersion"
}
```

Create a class to implement `MLSCastOptionsProviderAbstract`

```kotlin
class MCLSCastOptionsProvider : MLSCastOptionsProviderAbstract() {
    override fun getCastAppId(): String {
        return "4381F502" // Our receiver application id
    }
}
```

Add the class `AndroidManifest.xml`

```xml

<application>

    <!-- ... Activities -->

    <!-- Add this here, replace the value with your class path -->
    <meta-data android:name="com.google.android.gms.cast.framework.OPTIONS_PROVIDER_CLASS_NAME"
        android:value="tv.mycujoo.cast.MCLSCastOptionsProvider" />
</application>


```

## Usage

Cast is async, that's Google's choice not ours. So, we have added a build callback that gives you
that instance once ready.

```kotlin

import android.app.MediaRouteButton

var castPlayer: MCLSCast? = null

val castButton = findViewById<MediaRouteButton>(R.id.cast_button)

MCLSCast
    .Builder()
    .withActivity(this)
    .withAppId("4381F502")
    .withMediaButton(castButton)
    .withLifecycle(lifecycle)
    .withPublicKey("XXXXXX")
    .build {
        castPlayer = it
    }

```

And then you can play the event using `MCLSEvent`

```kotlin
castPlayer.playEvent(
    event = eventToPlay,
    playWhenReady = true, // If play when cast receiver app is ready.
    position = 0 // Start position in MS
)
```

### UI

In case you want a remote player view, in which you can pause, fast forward and fast backwards.

We provide a plug-and-play view to handle those events for you.

To set it up first, add the view into your activity/fragment/view:

```xml

<tv.mycujoo.mclscast.widget.RemotePlayerView android:id="@+id/remote_player_view"
    android:layout_width="match_parent" android:layout_height="match_parent" />
```

And then add this view to MCLSCast builder

```kotlin
import android.app.MediaRouteButton

var castPlayer: MCLSCast? = null

val castButton = findViewById<MediaRouteButton>(R.id.cast_button)
val remotePlayerView = findViewById<RemotePlayerView>(R.id.remote_player_view)

MCLSCast
    .Builder()
    .withActivity(this)
    .withAppId("4381F502")
    .withMediaButton(castButton)
    .withLifecycle(lifecycle)
    .withPublicKey("XXXXXX")
    .withRemotePlayerView(remotePlayerView)
    .build {
        castPlayer = it
    }

```

### Cast Event Listeners

To listen to cast events (connected, disconnected) you can add a listener to `MCLSCast`.

```kotlin
castPlayer!!.addListener(object : CastApplicationListener {
    override fun onApplicationConnected() {
        // Interact
    }

    override fun onApplicationDisconnected() {
        // Interact
    }
})
```

For more detailed event listening, you can add `CastSessionListener`

```kotlin
castPlayer!!.addListener(object : CastSessionListener() {
    // Override needed methods
})
```

For Class API, please refer to `docs/cast` or you can use the IDE code explorer.