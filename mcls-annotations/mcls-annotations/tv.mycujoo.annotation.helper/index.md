---
title: tv.mycujoo.annotation.helper
---
//[mcls-annotations](../../index.html)/[tv.mycujoo.annotation.helper](index.html)



# Package-level declarations



## Types


| Name | Summary |
|---|---|
| [AnimationClassifierHelper](-animation-classifier-helper/index.html) | [androidJvm]<br>class [AnimationClassifierHelper](-animation-classifier-helper/index.html)<br>Helper class to distinguish between animation types Each animation might be Static or Dynamic. Dynamic animations change their position as part of animation. either x, y or both might change during the animating phase. Static animations do NOT change their position at all. i.e. alpha might change. Animations can be valid for specific type, i.e. Fade-in animation is only valid for 'Intro' animation, and it is invalid for 'outro' animation. |
| [AnimationFactory](-animation-factory/index.html) | [androidJvm]<br>open class [AnimationFactory](-animation-factory/index.html)@Injectconstructor<br>Creates Android animation object 'ObjectAnimator' with given parameters. Parameter used in creating animation, Each animation needs a combination of these to be created: |
| [DownloaderClient](-downloader-client/index.html) | [androidJvm]<br>class [DownloaderClient](-downloader-client/index.html)@Injectconstructor(okHttpClient: OkHttpClient) : [IDownloaderClient](-i-downloader-client/index.html)<br>Implementation of IDownloaderClient which downloads & returns SVG Data |
| [IDownloaderClient](-i-downloader-client/index.html) | [androidJvm]<br>interface [IDownloaderClient](-i-downloader-client/index.html) |
| [IOverlayFactory](-i-overlay-factory/index.html) | [androidJvm]<br>interface [IOverlayFactory](-i-overlay-factory/index.html)<br>Contract for creating ready-to-be-displayed ScaffoldView |
| [ITypeFaceFactory](-i-type-face-factory/index.html) | [androidJvm]<br>interface [ITypeFaceFactory](-i-type-face-factory/index.html)<br>Contract for creating typeface which will be used in visualizing overlays. Custom fonts (typefaces) are used in overlays. |
| [IViewHandler](-i-view-handler/index.html) | [androidJvm]<br>interface [IViewHandler](-i-view-handler/index.html) |
| [OverlayFactory](-overlay-factory/index.html) | [androidJvm]<br>@Singleton<br>class [OverlayFactory](-overlay-factory/index.html)@Injectconstructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html), variableKeeper: [IVariableKeeper](../tv.mycujoo.annotation.manager/-i-variable-keeper/index.html)) : [IOverlayFactory](-i-overlay-factory/index.html)<br>Create overlay, which is the view used for displaying Annotation Action on screen. |
| [OverlayViewHelper](-overlay-view-helper/index.html) | [androidJvm]<br>@Singleton<br>class [OverlayViewHelper](-overlay-view-helper/index.html)@Injectconstructor(overlayHost: [IAnnotationView](../tv.mycujoo.annotation.annotation/-i-annotation-view/index.html), viewHandler: [IViewHandler](-i-view-handler/index.html), overlayFactory: [IOverlayFactory](-i-overlay-factory/index.html), animationFactory: [AnimationFactory](-animation-factory/index.html))<br>Helps with View related operations. i.e. Add/Remove overlay view to/from screen. |
| [SVGAssetResolver](-s-v-g-asset-resolver/index.html) | [androidJvm]<br>class [SVGAssetResolver](-s-v-g-asset-resolver/index.html)@Injectconstructor(typeFaceFactory: [ITypeFaceFactory](-i-type-face-factory/index.html)) : SVGExternalFileResolver<br>Implementation to SVGExternalFileResolver which is required by AndroidSVG library, in order to parse custom fonts. |
| [TimeRangeHelper](-time-range-helper/index.html) | [androidJvm]<br>class [TimeRangeHelper](-time-range-helper/index.html) |
| [TimeSystem](-time-system/index.html) | [androidJvm]<br>enum [TimeSystem](-time-system/index.html) : [Enum](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-enum/index.html)&lt;[TimeSystem](-time-system/index.html)&gt; <br>2 Types of time system may be used in SDK. Absolute means the given offset is actually value since the beginning of video. Relative is calculated based on current 'dvr' window size |
| [TypeFaceFactory](-type-face-factory/index.html) | [androidJvm]<br>class [TypeFaceFactory](-type-face-factory/index.html)@Injectconstructor(context: [Context](https://developer.android.com/reference/kotlin/android/content/Context.html)) : [ITypeFaceFactory](-i-type-face-factory/index.html)<br>Implementation of ITypeFaceFactory to create custom fonts for parsing SVG into view |

