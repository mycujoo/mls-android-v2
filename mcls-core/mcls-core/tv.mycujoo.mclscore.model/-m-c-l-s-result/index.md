---
title: MCLSResult
---
//[mcls-core](../../../index.html)/[tv.mycujoo.mclscore.model](../index.html)/[MCLSResult](index.html)



# MCLSResult

sealed class [MCLSResult](index.html)&lt;out [E](index.html), out [V](index.html)&gt;

A crash safe wrapper to a result that uses when to infer the status of the result



#### Samples



#### Inheritors


| |
|---|
| [Success](-success/index.html) |
| [NetworkError](-network-error/index.html) |
| [GenericError](-generic-error/index.html) |


## Types


| Name | Summary |
|---|---|
| [GenericError](-generic-error/index.html) | [androidJvm]<br>data class [GenericError](-generic-error/index.html)(val errorCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val errorMessage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [MCLSResult](index.html)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html), [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)&gt; |
| [NetworkError](-network-error/index.html) | [androidJvm]<br>data class [NetworkError](-network-error/index.html)&lt;out [E](-network-error/index.html)&gt;(val error: [E](-network-error/index.html)) : [MCLSResult](index.html)&lt;[E](-network-error/index.html), [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)&gt; |
| [Success](-success/index.html) | [androidJvm]<br>data class [Success](-success/index.html)&lt;out [V](-success/index.html)&gt;(val value: [V](-success/index.html)) : [MCLSResult](index.html)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html), [V](-success/index.html)&gt; |


## Functions


| Name | Summary |
|---|---|
| [valueOrNull](../../tv.mycujoo.mclscore.helper/value-or-null.html) | [androidJvm]<br>fun &lt;[Param](../../tv.mycujoo.mclscore.helper/value-or-null.html) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [MCLSResult](index.html)&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [Param](../../tv.mycujoo.mclscore.helper/value-or-null.html)&gt;.[valueOrNull](../../tv.mycujoo.mclscore.helper/value-or-null.html)(): [Param](../../tv.mycujoo.mclscore.helper/value-or-null.html)? |

