//[mcls-annotations](../../../index.md)/[tv.mycujoo.annotation.domain.entity](../index.md)/[TimelineMarkerEntity](index.md)

# TimelineMarkerEntity

[androidJvm]\
data class [TimelineMarkerEntity](index.md)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val seekOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val color: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Timeline marker info to mark some point on timeline based on Offset.

## Constructors

| | |
|---|---|
| [TimelineMarkerEntity](-timeline-marker-entity.md) | [androidJvm]<br>fun [TimelineMarkerEntity](-timeline-marker-entity.md)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), seekOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), color: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |

## Properties

| Name | Summary |
|---|---|
| [color](color.md) | [androidJvm]<br>val [color](color.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>marker color |
| [id](id.md) | [androidJvm]<br>val [id](id.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>identifier of action |
| [label](label.md) | [androidJvm]<br>val [label](label.md): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>marker text |
| [offset](offset.md) | [androidJvm]<br>val [offset](offset.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>offset at which marker should display on timeline |
| [seekOffset](seek-offset.md) | [androidJvm]<br>val [seekOffset](seek-offset.md): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>amount of seekable portion around timeline marker |
