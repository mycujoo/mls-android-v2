---
title: inputStreamToString
---
//[mcls-player](../../../index.html)/[tv.mycujoo.mclsplayer.player.utils](../index.html)/[StringUtils](index.html)/[inputStreamToString](input-stream-to-string.html)



# inputStreamToString



[androidJvm]\
fun [inputStreamToString](input-stream-to-string.html)(inputStream: [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html)): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?



Will read the content from a given [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html) and return it as a [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).



#### Return



Returns `null` if the the [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html) could not be read. Else returns the content of the [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html) as [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html).



#### Parameters


androidJvm

| | |
|---|---|
| inputStream | The [InputStream](https://developer.android.com/reference/kotlin/java/io/InputStream.html) which should be read. |




