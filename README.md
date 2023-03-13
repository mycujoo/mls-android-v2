# MCLS (MyCujoo Live Services) SDK For Android

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/mycujoo/mls-android-v2/tree/main.svg?style=svg&circle-token=328b6c285d7e39aa44ee54352f84e6b07e0b5582)](https://dl.circleci.com/status-badge/redirect/gh/mycujoo/mls-android-v2/tree/main)

## Overview

MLS Android SDK enables apps to play videos that are hosted on MyCujoo Live Service platform while making displaying of annotations possible.
MLS will handle all possible features an app needs to broadcast an event. From retrieving events list to displaying the video itself & annotations on it.

### Init MCLS Full Platform

Add dependency to SDK in app-level build.gradle file:

```groovy
implementation 'tv.mycujoo.mls:mls:MLS_LATEST_VERSION_HERE'
```

### Add MCLSView to your layout

```xml
<tv.mycujoo.mcls.widget.MCLSView
        android:id="@+id/mcls_view"
        android:layout_width="match_parent"
        android:layout_height="match_parent" />
```

### Play Events using Event ID

```kotlin
binding.mclsView.playEvent("EVENT_ID")
```

## Modules

We have provided different stand-alone modules that can be used out-the-box to fully customize your experience using this SDK:

### MCLS-Network

This module have all the networking capabilities of the SDK.
Those are

1. Fetching Event Details
2. Fetching all Annotations Actions for a given Timeline Id
3. Concurrency Control
4. Timeline updates

For more info and usage details please refer to <>

### MCLS-Player

This Module provide the player we use for video-playing events.
It can manage all situations that can happen when playing an event. It handles the conversion of `EventEntity` into a playable stream.

1. Convert `EventEntity` into a stream and playing it.
2. Handles DRM-Enabled `EventEntity` with HLS Widevine when needed.
3. Shows a poster with Event Details when the stream is not ready yet.
4. Handles errors when the user doesn't have the permission to see that event.

For more info and usage details please refer to <>

### MCLS-Annotations

This module provide the ability to process and display Annotation Actions in a given View.

You can provide the view yourself if you want a custom behaviour, or you can use our adapters for faster and more supported behaviour.

Using this module enables you to plug that View as an overlay over your player,
and we handle the processing, attaching, reattaching and cleaning the screen of any `Action` that doesn't correlate with the video player
current timestamp in the event.

For more info and usage details please refer to <>

#### MCLS-Core

Definitions and Types used across all other modules

#### MCLS

An easy to use Plug-and-play solution to handle all the above modules.

