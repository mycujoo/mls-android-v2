# MCLSPlayer Compose

A wrapper for MCLSPlayer to make it usable in Jetpack Compose Applications.

## Important Note

This module is still in Beta stage, everything you see here is subject to change. the interactivity
with this module isn't complete yet, IMA integration, Analytics and Synchronizing the instance with
`MediaPlayer` is still in the works.

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
    implementation "tv.mycujoo.mcls:mclsplayercompose:$latestVersion"
}
```

## Usage

first initialize the player outside the view

```kotlin
class MainActivity : ComponentActivity() {

    private val mclsPlayer = MCLSVideo()
    
    // ...
}
```

then inflate the view inside the view tree

```kotlin
class MainActivity : ComponentActivity() {

    private val mclsPlayer = MCLSVideo()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Column {
                mclsPlayer.MCLSPlayerView(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(Dp(240F))
                )
                Button(
                    onClick = {
                        mclsPlayer.playEvent(eventToPlay)
                    }
                ) {
                    Text(text = "Play Event")
                }
                // Other views
            }
            // Other views
        }
    }
}
```
