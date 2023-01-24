---
title: DownloaderClient
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.helper](../index.html)/[DownloaderClient](index.html)



# DownloaderClient



[androidJvm]\
class [DownloaderClient](index.html)@Injectconstructor(okHttpClient: OkHttpClient) : [IDownloaderClient](../-i-downloader-client/index.html)

Implementation of IDownloaderClient which downloads & returns SVG Data



#### See also


androidJvm

| |
|---|
| [IDownloaderClient](../-i-downloader-client/index.html) |
| SvgData |



## Constructors


| | |
|---|---|
| [DownloaderClient](-downloader-client.html) | [androidJvm]<br>@Inject<br>fun [DownloaderClient](-downloader-client.html)(okHttpClient: OkHttpClient)<br>takes okHttpClient which will have a Cache layer to skip downloading repeated SVGs |


## Functions


| Name | Summary |
|---|---|
| [download](download.html) | [androidJvm]<br>open override fun [download](download.html)(showOverlayAction: AnnotationAction.ShowOverlayAction, callback: (AnnotationAction.ShowOverlayAction) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>download SVG & call with ready-to-parse SVGData |

