//[mcls-core](../../../../index.md)/[tv.mycujoo.mclscore.model](../../index.md)/[Variable](../index.md)/[DoubleVariable](index.md)

# DoubleVariable

[androidJvm]\
data class [DoubleVariable](index.md)(val name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), var value: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), val doublePrecision: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null) : [Variable](../index.md)

A variable which holds a value of type Double

## Constructors

| | |
|---|---|
| [DoubleVariable](-double-variable.md) | [androidJvm]<br>fun [DoubleVariable](-double-variable.md)(name: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), value: [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html), doublePrecision: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null) |

## Functions

| Name | Summary |
|---|---|
| [copy](copy.md) | [androidJvm]<br>open override fun [copy](copy.md)(): [Variable.DoubleVariable](index.md) |
| [increment](increment.md) | [androidJvm]<br>open override fun [increment](increment.md)(amount: [Any](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-any/index.html)) |
| [printValue](print-value.md) | [androidJvm]<br>open override fun [printValue](print-value.md)(): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

## Properties

| Name | Summary |
|---|---|
| [doublePrecision](double-precision.md) | [androidJvm]<br>val [doublePrecision](double-precision.md): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)? = null |
| [name](name.md) | [androidJvm]<br>open override val [name](name.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [value](value.md) | [androidJvm]<br>var [value](value.md): [Double](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-double/index.html) |
