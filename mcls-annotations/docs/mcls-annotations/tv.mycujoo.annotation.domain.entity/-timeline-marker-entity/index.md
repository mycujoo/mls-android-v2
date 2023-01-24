---
title: TimelineMarkerEntity
---
//[mcls-annotations](../../../index.html)/[tv.mycujoo.annotation.domain.entity](../index.html)/[TimelineMarkerEntity](index.html)



# TimelineMarkerEntity



[androidJvm]\
data class [TimelineMarkerEntity](index.html)(val id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val seekOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), val label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), val color: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html))

Timeline marker info to mark some point on timeline based on Offset.



## Constructors


| | |
|---|---|
| [TimelineMarkerEntity](-timeline-marker-entity.html) | [androidJvm]<br>fun [TimelineMarkerEntity](-timeline-marker-entity.html)(id: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), offset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), seekOffset: [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html), label: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), color: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) |


## Properties


| Name | Summary |
|---|---|
| [color](color.html) | [androidJvm]<br>val [color](color.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>marker color |
| [id](id.html) | [androidJvm]<br>val [id](id.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>identifier of action |
| [label](label.html) | [androidJvm]<br>val [label](label.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)<br>marker text |
| [offset](offset.html) | [androidJvm]<br>val [offset](offset.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>offset at which marker should display on timeline |
| [seekOffset](seek-offset.html) | [androidJvm]<br>val [seekOffset](seek-offset.html): [Long](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-long/index.html)<br>amount of seekable portion around timeline marker |

