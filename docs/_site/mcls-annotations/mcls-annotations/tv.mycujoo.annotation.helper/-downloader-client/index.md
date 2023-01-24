//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.helper](../index.md)/[DownloaderClient](index.md)

# DownloaderClient

[androidJvm]\
class [DownloaderClient](index.md)@Injectconstructor(okHttpClient: OkHttpClient) : [IDownloaderClient](../-i-downloader-client/index.md)

Implementation of IDownloaderClient which downloads & returns SVG Data

#### See also

androidJvm

| |
|---|
| [IDownloaderClient](../-i-downloader-client/index.md) |
| SvgData |

## Constructors

| | |
|---|---|
| [DownloaderClient](-downloader-client.md) | [androidJvm]<br>@Inject<br>fun [DownloaderClient](-downloader-client.md)(okHttpClient: OkHttpClient)<br>takes okHttpClient which will have a Cache layer to skip downloading repeated SVGs |

## Functions

| Name | Summary |
|---|---|
| [download](download.md) | [androidJvm]<br>open override fun [download](download.md)(showOverlayAction: AnnotationAction.ShowOverlayAction, callback: (AnnotationAction.ShowOverlayAction) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))<br>download SVG & call with ready-to-parse SVGData |
