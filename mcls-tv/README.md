# MCLS TV

A complete plug-and-play SDK used to consume MCLS APIs and services

For api documentation please refer to the `docs/mcls-tv` in this repo's root

For samples, please refer to `samples/tv` which contains an extensive sample that uses all
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
    implementation "tv.mycujoo.mcls:mclstv:$latestVersion"
}
```

## Usage

In your `FragmentActivity` add the playback fragment as following

```kotlin
private val mclsTvFragment = MCLSTVFragment()

override fun onCreate(savedInstanceState: Bundle?) {
    // ...
    supportFragmentManager
        .beginTransaction()
        .replace(binding.fragmentContainer.id, mclsTvFragment)
        .commit()
    // ...

    // Set the public key
    mclsTvFragment.setPublicKey("PUBLIC_KEY")
    
    // (Optional) Set the identity token
    mclsTvFragment.setIdentityToken("IDENTITY_TOKEN")
}

override fun onResumeFragments() {
    super.onResumeFragments()

    // Play the event once the fragment is ready
    mclsTvFragment.playEvent("EVENT_ID")
}
```

### Arguments

You can pass the following as arguments

| Name                               | Type                       | Description                                             |
|------------------------------------|----------------------------|---------------------------------------------------------|
| MCLSTVFragment.PUBLIC_KEY          | String                     | public key for MCLS (linked to your org)                |
| MCLSTVFragment.MCLS_EVENT_ID       | String                     | Event Id to play once the fragment is ready             |
| MCLSTVFragment.IMA_AD_UNIT_VOD     | String                     | Ad unit for vod events                                  |
| MCLSTVFragment.IMA_AD_UNIT_LIVE    | String                     | Ad unit for live events, if empty vod unit will be used |
| MCLSTVFragment.IMA_PARAMS          | MCLSIMAParams (Parcelable) | IMA arguments used for ad targeting                     |
| MCLSTVFragment.MCLS_IDENTITY_TOKEN | String                     | Identity token (used for protected content)             |

With those params you should be able to use MCLSTVFragment with Navigation Components.

In case you used arguments, no need to use `setPublicKey` and `setIdentityToken`.
