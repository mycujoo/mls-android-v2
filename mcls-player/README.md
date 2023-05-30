# MCLS Player

A local video player used to stream matches from MCLS.

This player has nothing to do with `AnnotationAction`s, and it will not manage casts.
For those needs please refer to `MCLSView`, `MCLSCast` and `AnnotationManager` Modules in this
repository.

For api documentation please refer to the `docs/mcls-player` in this repo's root

For samples, please refer to `samples/player` which contains an extensive sample that uses all
player features.

## Installation

if you're using `setting.gradle` please add the following

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url "https://npaw.jfrog.io/artifactory/youbora/" } // <-- This one
    }
}
```

If you're using `build.gradle` to manage dependency resolution please use

```groovy
allprojects {
    repositories {
        google()
        mavenCentral()
        maven { url "https://npaw.jfrog.io/artifactory/youbora/" }
    }
}
```

Then you can import the player using in your app (or feature) module add this one to your
dependencies

```groovy
dependencies {
    // ... Other imports 

    def latestVersion = "1.0.0" // Use the latest version
    implementation "tv.mycujoo.mcls:mclsplayer:$latestVersion"
}
```

## Usage

First declare the player view in layout xml

```xml

<tv.mycujoo.mclsplayer.player.widget.MCLSPlayerView
    android:id="@+id/mcls_player_view"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```

Now, inside your Activity/Fragment build the module

```kotlin
val playerView = findViewById<MCLSPlayerView>(R.id.mcls_player_view)
val player = MCLSPlayer.Builder()
    .withPlayerView(playerView)
    .withActivity(this)
    .withContext(this)
    .build()
```

And, the player is ready now for playback requests

You can play an event using the following

```kotlin
player.playEvent(
    MCLSEvent(
        id = "1",
        title = "Awesome Title",
        description = null,
        thumbnailUrl = null,
        poster_url = null,
        location = null,
        organiser = null,
        start_time = null,
        status = EventStatus.EVENT_STATUS_STARTED,
        streams = listOf(
            MCLSStream(
                id = "StreamID",
                fullUrl = "STREAM_URL", // Use a real video url here
                dvrWindowString = null,
                widevine = null,
            )
        ),
        timezone = null,
        timeline_ids = emptyList(),
        metadata = null,
        is_test = true
    )
)
```

Or you can grab an event by id from `MCLSNetwork`, and inject it inside the player

```kotlin
mclsNetwork.getEventDetails(eventId) {
    player.playEvent(it)
}
```

### Styling the player

To style the player, you just need to provide a `VideoPlayerConfig` while building the player

```kotlin
val playerConfig = VideoPlayerConfig(
    primaryColor = "#FFFFFF",
    secondaryColor = "#000000",
    autoPlay = true,
    enableControls = true,
    showPlayPauseButtons = true,
    showBackForwardsButtons = true,
    showSeekBar = true,
    showTimers = true,
    showFullScreenButton = true,
    showLiveViewers = true,
    showEventInfoButton = true
)

val playerView = findViewById<MCLSPlayerView>(R.id.mcls_player_view)
val player = MCLSPlayer.Builder()
    .withPlayerView(playerView)
    .withActivity(this)
    .withContext(this)
    .withPlayerConfig(playerConfig)
    .build()
```

### IMA Integration

To Add an IMA integration to this player, you only need to add an implementation of the IIMA to this
module.

```kotlin
val imaAdUnitVod = "IMA_AD_UNIT_VOD"
val imaAdUnitLive = "IMA_AD_UNIT_LIVE"
val playerView = findViewById<MCLSPlayerView>(R.id.mcls_player_view)
val player = MCLSPlayer.Builder()
    .withPlayerView(playerView)
    .withActivity(this)
    .withContext(this)
    .withIma(Ima(
        adUnit = imaAdUnitVod, // Ad unit for finished events
        liveAdUnit = imaAdUnitLive, // Ad unit for live events
        paramProvider = {
            buildMap {
                // Targeting params
            }
        }
    ))
    .build()
```

liveAdUnit can be null, if so, the player will use VOD ad unit instead.
paramProvider can be null

### Analytics

To be able to identify your users, you can use pseudo user ids, and user ids, then you can query
them accordingly. Pseudo user ids are used to identify anonymous users, and user id is used to
identify logged in users.

Please note that we collect data across all our clients for quality assurance purposes. So, your
privacy policy should reflect this.

To use this feature please use:

```kotlin
val playerView = findViewById<MCLSPlayerView>(R.id.mcls_player_view)
val player = MCLSPlayer.Builder()
    .withPlayerView(playerView)
    .withActivity(this)
    .withContext(this)
    .withPseudoUserId("PSEUDO_USER_ID")
    .withUserId("USER_ID")
    .build()
```

### ExoPlayer

This module is based on `ExoPlayer` for actual video playback, this means that having multiple player can be expensive.
So, we have provided a way to use your own `ExoPlayer` instance so you don't have to worry about
conflicting ExoPlayer instances in memory at the same time.

To use your own `ExoPlayer` instance just pass it while building the player

```kotlin
val externalExoPlayer = ExoPlayer.Builder(this).build()
val playerView = findViewById<MCLSPlayerView>(R.id.mcls_player_view)
val player = MCLSPlayer.Builder()
    .withPlayerView(playerView)
    .withActivity(this)
    .withContext(this)
    .withExoPlayer(externalExoPlayer)
    .build()
```

