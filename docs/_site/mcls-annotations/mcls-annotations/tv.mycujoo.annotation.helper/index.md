//[mcls-annotations](../../index.md)/[tv.mycujoo.annotation.helper](index.md)

# Package-level declarations

## Types

| Name | Summary |
|---|---|
| [AnimationClassifierHelper](-animation-classifier-helper/index.md) | [androidJvm]<br>class [AnimationClassifierHelper](-animation-classifier-helper/index.md)<br>Helper class to distinguish between animation types Each animation might be Static or Dynamic. Dynamic animations change their position as part of animation. either x, y or both might change during the animating phase. Static animations do NOT change their position at all. i.e. alpha might change. Animations can be valid for specific type, i.e. Fade-in animation is only valid for 'Intro' animation, and it is invalid for 'outro' animation. |
| [AnimationFactory](-animation-factory/index.md) | [androidJvm]<br>open class [AnimationFactory](-animation-factory/index.md)@Injectconstructor<br>Creates Android animation object 'ObjectAnimator' with given parameters. Parameter used in creating animation, Each animation needs a combination of these to be created: |
| [DownloaderClient](-downloader-client/index.md) | [androidJvm]<br>class [DownloaderClient](-downloader-client/index.md)@Injectconstructor(okHttpClient: OkHttpClient) : [IDownloaderClient](-i-downloader-client/index.md)<br>Implementation of IDownloaderClient which downloads & returns SVG Data |
| [IDownloaderClient](-i-downloader-client/index.md) | [androidJvm]<br>interface [IDownloaderClient](-i-downloader-client/index.md) |
| [IOverlayFactory](-i-overlay-factory/index.md) | [androidJvm]<br>interface [IOverlayFactory](-i-overlay-factory/index.md)<br>Contract for creating ready-to-be-displayed ScaffoldView |
| [IViewHandler](-i-view-handler/index.md) | [androidJvm]<br>interface [IViewHandler](-i-view-handler/index.md) |
| [OverlayFactory](-overlay-factory/index.md) | [androidJvm]<br>@Singleton<br>class [OverlayFactory](-overlay-factory/index.md)@Injectconstructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), variableKeeper: [IVariableKeeper](../tv.mycujoo.annotation.manager/-i-variable-keeper/index.md)) : [IOverlayFactory](-i-overlay-factory/index.md)<br>Create overlay, which is the view used for displaying Annotation Action on screen. |
| [OverlayViewHelper](-overlay-view-helper/index.md) | [androidJvm]<br>@Singleton<br>class [OverlayViewHelper](-overlay-view-helper/index.md)@Injectconstructor(overlayHost: [IAnnotationView](../tv.mycujoo.annotation.annotation/-i-annotation-view/index.md), viewHandler: [IViewHandler](-i-view-handler/index.md), overlayFactory: [IOverlayFactory](-i-overlay-factory/index.md), animationFactory: [AnimationFactory](-animation-factory/index.md))<br>Helps with View related operations. i.e. Add/Remove overlay view to/from screen. |
| [TimeRangeHelper](-time-range-helper/index.md) | [androidJvm]<br>class [TimeRangeHelper](-time-range-helper/index.md) |
| [TimeSystem](-time-system/index.md) | [androidJvm]<br>enum [TimeSystem](-time-system/index.md) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[TimeSystem](-time-system/index.md)&gt; <br>2 Types of time system may be used in SDK. Absolute means the given offset is actually value since the beginning of video. Relative is calculated based on current 'dvr' window size |
