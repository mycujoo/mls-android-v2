---
title: Variable
---
//[mcls-core](../../../index.html)/[tv.mycujoo.mclscore.model](../index.html)/[Variable](index.html)



# Variable

sealed class [Variable](index.html)

Variable are used in overlays, i.e. team scores



#### Inheritors


| |
|---|
| [LongVariable](-long-variable/index.html) |
| [DoubleVariable](-double-variable/index.html) |
| [StringVariable](-string-variable/index.html) |
| [InvalidVariable](-invalid-variable/index.html) |


## Types


| Name | Summary |
|---|---|
| [DoubleVariable](-double-variable/index.html) | [androidJvm]<br>data class [DoubleVariable](-double-variable/index.html)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var value: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val doublePrecision: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null) : [Variable](index.html)<br>A variable which holds a value of type Double |
| [InvalidVariable](-invalid-variable/index.html) | [androidJvm]<br>data class [InvalidVariable](-invalid-variable/index.html)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) : [Variable](index.html)<br>Invalid variables which can be categories in other Variables, are defined as InvalidVariable. |
| [LongVariable](-long-variable/index.html) | [androidJvm]<br>data class [LongVariable](-long-variable/index.html)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var value: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)) : [Variable](index.html)<br>A variable  which holds a value of type Long |
| [StringVariable](-string-variable/index.html) | [androidJvm]<br>data class [StringVariable](-string-variable/index.html)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var value: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) : [Variable](index.html)<br>A variable which holds a value of type Double |


## Functions


| Name | Summary |
|---|---|
| [copy](copy.html) | [androidJvm]<br>abstract fun [copy](copy.html)(): [Variable](index.html) |
| [increment](increment.html) | [androidJvm]<br>abstract fun [increment](increment.html)(amount: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)) |
| [printValue](print-value.html) | [androidJvm]<br>abstract fun [printValue](print-value.html)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |


## Properties


| Name | Summary |
|---|---|
| [name](name.html) | [androidJvm]<br>abstract val [name](name.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

