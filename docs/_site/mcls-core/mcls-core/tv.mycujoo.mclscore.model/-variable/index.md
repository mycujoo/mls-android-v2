//[mcls-core](../../../index.md)/[tv.mycujoo.mclscore.model](../index.md)/[Variable](index.md)

# Variable

[androidJvm]\
sealed class [Variable](index.md)

Variable are used in overlays, i.e. team scores

## Types

| Name | Summary |
|---|---|
| [DoubleVariable](-double-variable/index.md) | [androidJvm]<br>data class [DoubleVariable](-double-variable/index.md)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var value: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val doublePrecision: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null) : [Variable](index.md)<br>A variable which holds a value of type Double |
| [InvalidVariable](-invalid-variable/index.md) | [androidJvm]<br>data class [InvalidVariable](-invalid-variable/index.md)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) : [Variable](index.md)<br>Invalid variables which can be categories in other Variables, are defined as InvalidVariable. |
| [LongVariable](-long-variable/index.md) | [androidJvm]<br>data class [LongVariable](-long-variable/index.md)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var value: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [Variable](index.md)<br>A variable  which holds a value of type Long |
| [StringVariable](-string-variable/index.md) | [androidJvm]<br>data class [StringVariable](-string-variable/index.md)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Variable](index.md)<br>A variable which holds a value of type Double |

## Functions

| Name | Summary |
|---|---|
| [copy](copy.md) | [androidJvm]<br>abstract fun [copy](copy.md)(): [Variable](index.md) |
| [increment](increment.md) | [androidJvm]<br>abstract fun [increment](increment.md)(amount: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)) |
| [printValue](print-value.md) | [androidJvm]<br>abstract fun [printValue](print-value.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [name](name.md) | [androidJvm]<br>abstract val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Inheritors

| Name |
|---|
| [LongVariable](-long-variable/index.md) |
| [DoubleVariable](-double-variable/index.md) |
| [StringVariable](-string-variable/index.md) |
| [InvalidVariable](-invalid-variable/index.md) |
