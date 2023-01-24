//[mcls-core](../../../index.md)/[tv.mycujoo.mclscore.model](../index.md)/[MCLSResult](index.md)

# MCLSResult

[androidJvm]\
sealed class [MCLSResult](index.md)&lt;out [E](index.md), out [V](index.md)&gt;

## Types

| Name | Summary |
|---|---|
| [GenericError](-generic-error/index.md) | [androidJvm]<br>data class [GenericError](-generic-error/index.md)(val errorCode: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html), val errorMessage: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [MCLSResult](index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html), [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)&gt; |
| [NetworkError](-network-error/index.md) | [androidJvm]<br>data class [NetworkError](-network-error/index.md)&lt;out [E](-network-error/index.md)&gt;(val error: [E](-network-error/index.md)) : [MCLSResult](index.md)&lt;[E](-network-error/index.md), [Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html)&gt; |
| [Success](-success/index.md) | [androidJvm]<br>data class [Success](-success/index.md)&lt;out [V](-success/index.md)&gt;(val value: [V](-success/index.md)) : [MCLSResult](index.md)&lt;[Nothing](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-nothing/index.html), [V](-success/index.md)&gt; |

## Inheritors

| Name |
|---|
| [Success](-success/index.md) |
| [NetworkError](-network-error/index.md) |
| [GenericError](-generic-error/index.md) |

## Extensions

| Name | Summary |
|---|---|
| [valueOrNull](../../tv.mycujoo.mclscore.helper/value-or-null.md) | [androidJvm]<br>fun &lt;[Param](../../tv.mycujoo.mclscore.helper/value-or-null.md) : [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)&gt; [MCLSResult](index.md)&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [Param](../../tv.mycujoo.mclscore.helper/value-or-null.md)&gt;.[valueOrNull](../../tv.mycujoo.mclscore.helper/value-or-null.md)(): [Param](../../tv.mycujoo.mclscore.helper/value-or-null.md)? |
