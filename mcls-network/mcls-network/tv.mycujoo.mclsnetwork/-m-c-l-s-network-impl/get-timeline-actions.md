---
title: getTimelineActions
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork](../index.html)/[MCLSNetworkImpl](index.html)/[getTimelineActions](get-timeline-actions.html)



# getTimelineActions



[androidJvm]\
open suspend override fun [getTimelineActions](get-timeline-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;&gt;



Fetches a list of Annotation Actions from the api, and returns them in a response wrapper for safe execution



#### Return



a result wrapper of AnnotationAction for safe execution



#### Parameters


androidJvm

| | |
|---|---|
| timelineId | the id of the timeline needed |
| updateId | a key used to get the latest update of a given timeline. |



#### See also


| |
|---|
| MCLSResult |



