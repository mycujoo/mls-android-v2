# MCLSNetwork

MCLS Network Client. For samples please refer to `samples/network`.

This module is responsible for:

1. Event Details Fetches
2. Event List Fetches
3. Annotation Actions List Fetches
4. Event Updates
5. Annotation Actions Update
6. Concurrency Management 

For filter syntax of `getEventList()` please refer to [MCLS Api Docs](https://mcls.mycujoo.tv/api-docs/)

## Installation

you can import the player using in your app (or feature) module in `build.gradle` add this one to
your dependencies

```groovy
dependencies {
    // ... Other imports 

    def latestVersion = "1.0.0" // Use the latest version
    implementation "tv.mycujoo.mcls:mcls-annotations:$latestVersion"
}
```

## Usage

First you build the client

```kotlin
val mclsNetwork = MCLSNetwork.Builder()
    .withContext(context)
    .withPublicKey("YOUR_PUBLIC_KEY")
    .build()
```

And then we use it to get data

```kotlin
mclsNetwork.getEventsList(
    pageSize = 10,
    filter = "status:EVENT_STATUS_FINISHED"
) { eventList, _, _ ->
    _events.postValue(eventList)
}
```

For API usage please refer to `samples/network`.

## Interactive Calls (Event Updates, Annotation Actions Updates)

```kotlin
mclsNetwork.addOnAnnotationActionsUpdateListener { updatedAnnotationActions ->
    // Inject into AnnotationManager
}

mclsNetwork.addOnEventUpdateListener { event ->
    // Inject into MCLSPlayer or MCLSCast
}

// Subscribe to the updates on a given event
mclsNetwork.joinEventAndTimelineUpdates(
    eventId,
    viewModelScope
)
```