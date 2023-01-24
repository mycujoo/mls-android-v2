//[mcls-player](../../../index.md)/[tv.mycujoo.mclsplayer.player.utils](../index.md)/[MathUtils](index.md)/[safeLongToInt](safe-long-to-int.md)

# safeLongToInt

[androidJvm]\
fun [safeLongToInt](safe-long-to-int.md)(numLong: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)): [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)

Convert long to int safely. Similar with Math.toIntExact() in Java 8.

#### Return

int version of input.

#### Parameters

androidJvm

| | |
|---|---|
| numLong | Number of type long to convert. |

#### Throws

| | |
|---|---|
| [ArithmeticException](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-arithmetic-exception/index.html) | If input overflows int. |
