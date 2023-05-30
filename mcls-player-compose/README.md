# MCLSPlayer Compose

A wrapper for MCLSPlayer to make it usable in Jetpack Compose Applications

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

