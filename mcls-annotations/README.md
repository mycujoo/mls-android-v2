# Annotations Manager

This module is responsible for the management of `AnnotationAction`s inside a given view.
This means that this module is responsible for all timers, variables, overlays and the such inside
`AnnotationView` independent from the player used.

In effect this module can be used with MCLSPlayer, with MCLSCast and with your own player.

For a completely working sample please refer to `samples/annotations` where you can start and play
around with the code.

For notes about `AnnotationAction`s, what they do and how they are used please refer to the MCLS
Platform documentation at [MCLS Console](https://mcls.mycujoo.tv/).

## Installation

you can import the player using in your app (or feature) module add this one to your dependencies

```groovy
dependencies {
    // ... Other imports 

    def latestVersion = "1.0.0" // Use the latest version
    implementation "tv.mycujoo.mcls:mcls-annotations:$latestVersion"
}
```

## Usage

### 1. inflate `AnnotationView` view

You can achieve this by doing it several ways:

Using XML

```xml

<tv.mycujoo.annotation.widget.AnnotationView android:id="@+id/annotation_view"
    android:layout_width="match_parent" android:layout_height="match_parent" />
```

Using Kotlin/Java

```kotlin
val annotationView = AnnotationView(context)
rootView.addView(annotationView)
```

As an ExoPlayer Overlay

```kotlin
findViewById<FrameLayout>(com.google.android.exoplayer2.R.id.exo_content_frame)
    .addView(annotationView)
```

### 2. build the manager

```kotlin
val annotationManager = AnnotationManager.Builder()
    .withAnnotationView(binding.annotationView)
    .withContext(this)
    .build()
```

### 3. Attach a player

In case you're wondering, currentPosition is only executed on MainThread. We recommend 1 refresh per
second.

In case you're using MCLSPlayer

```kotlin
newManager.attachPlayer(object : VideoPlayer {
    override fun currentPosition(): Long {
        return if (mclsPlayer.player.isPlayingAd()) {
            0
        } else {
            mclsPlayer.player.currentPosition()
        }
    }
})
```

Or if you're using ExoPlayer or any other players

```kotlin
annotationManager.attachPlayer(object : VideoPlayer {
    override fun currentPosition(): Long {
        return if (exoPlayer.isPlayingAd) {
            0
        } else {
            exoPlayer.currentPosition
        }
    }
})
```

### 4. Set `AnnotationAction`s

You can attach `AnnotationAction`s acquired directly from `MCLSNetwork`

```kotlin
val actions = MCLSNetwork.getTimelineActions("TIMELINE_ID")
annotationManager.setActions(actions)
```

Or map it yourself in case needed.

```kotlin
annotationManager.setActions(
    listOf(
        AnnotationAction.ShowOverlayAction(
            absoluteTime = 0,
            offset = 0,
            id = "1",
            duration = 5000,
            svgData = SvgData(
                svgUrl = "SVG_URL"
            ),
            viewSpec = ViewSpec(
                positionGuide = PositionGuide(
                    left = 0f,
                    top = 0f
                ),
                size = Pair(35F, 100F)
            )
        )
    )
)
```

## For Non-Player applications

If more accurate refreshes, multiple refresh cycles per second can be triggered via `setTime`.

```kotlin
annotationManager.setTime(3000) // Current Playback Position in ms
```
