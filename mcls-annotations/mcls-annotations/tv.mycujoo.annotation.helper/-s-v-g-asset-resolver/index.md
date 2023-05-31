---
title: SVGAssetResolver
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.helper](../index.html)/[SVGAssetResolver](index.html)



# SVGAssetResolver

class [SVGAssetResolver](index.html)@Injectconstructor(typeFaceFactory: [ITypeFaceFactory](../-i-type-face-factory/index.html)) : SVGExternalFileResolver

Implementation to SVGExternalFileResolver which is required by AndroidSVG library, in order to parse custom fonts.



#### See also


| |
|---|
| SVGExternalFileResolver |


## Constructors


| | |
|---|---|
| [SVGAssetResolver](-s-v-g-asset-resolver.html) | [androidJvm]<br>@Inject<br>constructor(typeFaceFactory: [ITypeFaceFactory](../-i-type-face-factory/index.html)) |


## Types


| Name | Summary |
|---|---|
| [Companion](-companion/index.html) | [androidJvm]<br>object [Companion](-companion/index.html) |


## Functions


| Name | Summary |
|---|---|
| [isFormatSupported](index.html#-1602194293%2FFunctions%2F378504164) | [androidJvm]<br>open fun [isFormatSupported](index.html#-1602194293%2FFunctions%2F378504164)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Boolean](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-boolean/index.html) |
| [resolveCSSStyleSheet](index.html#1302350165%2FFunctions%2F378504164) | [androidJvm]<br>open fun [resolveCSSStyleSheet](index.html#1302350165%2FFunctions%2F378504164)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [resolveFont](resolve-font.html) | [androidJvm]<br>open override fun [resolveFont](resolve-font.html)(fontFamily: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, fontWeight: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), fontStyle: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): [Typeface](https://developer.android.com/reference/kotlin/android/graphics/Typeface.html)? |
| [resolveImage](index.html#-1173336161%2FFunctions%2F378504164) | [androidJvm]<br>open fun [resolveImage](index.html#-1173336161%2FFunctions%2F378504164)(p0: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)): [Bitmap](https://developer.android.com/reference/kotlin/android/graphics/Bitmap.html) |

