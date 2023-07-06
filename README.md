# MCLS (MyCujoo Live Services) SDK For Android

[![CircleCI](https://dl.circleci.com/status-badge/img/gh/mycujoo/mls-android-v2/tree/main.svg?style=svg&circle-token=328b6c285d7e39aa44ee54352f84e6b07e0b5582)](https://dl.circleci.com/status-badge/redirect/gh/mycujoo/mls-android-v2/tree/main)

## Overview

MLS Android SDK enables apps to play videos that are hosted on MyCujoo Live Service platform while
making displaying of annotations possible.
MLS will handle all possible features an app needs to broadcast an event. From retrieving events
list to displaying the video itself & annotations on it.

For API Documentation please refer to [Here](https://mycujoo.github.io/mls-android-v2)

For details usage guide you can use the [Wiki](https://github.com/mycujoo/mls-android-v2/wiki), Or
you can use the `README.md` in each module you plan to use (faster updates here).

For usage samples, please refer to [Here](https://github.com/mycujoo/mls-android-v2/tree/main/samples), in which we will make exhausted samples and 
usage guides that you can use as a reference.

## Installation

if you're using `setting.gradle` please add the following

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url "https://npaw.jfrog.io/artifactory/youbora/" } // <-- Add this one
    }
}
```

If you're using `build.gradle` to manage dependency resolution please use

```groovy
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url "https://npaw.jfrog.io/artifactory/youbora/" } // <-- Add this one
    }
}
```

Then you can import the player using in your app (or feature) module add this one to your
dependencies

```groovy
dependencies {
    // ... Other imports 

    def latestVersion = "1.0.0" // Use the latest version
    implementation "tv.mycujoo.mls:mcls:$latestVersion"
}
```

## Usage

Add MCLSView to your layout

```xml

<tv.mycujoo.mcls.widget.MCLSView
    android:id="@+id/mcls_view"
    android:layout_width="match_parent"
    android:layout_height="match_parent" />
```

Set the public key

```kotlin
mclsView.setPublicKey("PUBLIC_KEY")
```

Play Events using Event ID

```kotlin
binding.mclsView.playEvent("EVENT_ID")
```

## Modules

We have provided different stand-alone modules that can be used out-the-box to fully customize your
experience using this SDK:

### MCLS-Network

This module have all the networking capabilities of the SDK.
Those are

1. Fetching Event Details
2. Fetching all Annotations Actions for a given Timeline Id
3. Concurrency Control
4. Timeline updates
5. Event and Event Timeline updates management

For more info and usage details please refer to [Here](https://github.com/mycujoo/mls-android-v2/wiki/MCLS-Network)

### MCLS-Player

This Module provide the player we use for video-playing events.
It can manage all situations that can happen when playing an event. It handles the conversion
of `EventEntity` into a playable stream.

1. Convert `EventEntity` into a stream and playing it.
2. Handles DRM-Enabled `EventEntity` with HLS Widevine when needed.
3. Shows a poster with Event Details when the stream is not ready yet.
4. Handles errors when the user doesn't have the permission to see that event.

For more info and usage details please refer to [HERE](https://github.com/mycujoo/mls-android-v2/wiki/MCLS-Player)

### MCLS-Annotations

This module provide the ability to process and display Annotation Actions in a given View.

You can provide the view yourself if you want a custom behaviour, or you can use our adapters for
faster and more supported behaviour.

Using this module enables you to plug that View as an overlay over your player,
and we handle the processing, attaching, reattaching and cleaning the screen of any
`AnnotationAction` that doesn't correlate with the video player
current timestamp in the event.

For more info and usage details please refer to [HERE](https://github.com/mycujoo/mls-android-v2/wiki/MCLS-Annoations)

### MCLS-Core

Definitions and Types used across all other modules

### MCLS

An easy to use Plug-and-play solution to handle all the above modules.

