---
title: getTimelineActions
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork](../index.html)/[MCLSNetwork](index.html)/[getTimelineActions](get-timeline-actions.html)



# getTimelineActions



[androidJvm]\
abstract suspend fun [getTimelineActions](get-timeline-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;&gt;



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




[androidJvm]\
abstract suspend fun [getTimelineActions](get-timeline-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, onSuccess: ([List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html))



An automatic unwrap for [getTimelineActions](get-timeline-actions.html) result



#### Parameters


androidJvm

| |
|---|
| timelineId |
| updateId |
| onSuccess | a callback executed when Timeline request success |



#### See also


| |
|---|
| [MCLSNetwork.getTimelineActions](get-timeline-actions.html) |
| AnnotationAction |




[androidJvm]\
abstract suspend fun [getTimelineActions](get-timeline-actions.html)(timelineId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), updateId: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)? = null, onSuccess: ([List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;AnnotationAction&gt;) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html), onError: ([String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?)



An automatic unwrap for [getTimelineActions](get-timeline-actions.html) result



#### Parameters


androidJvm

| |
|---|
| timelineId |
| updateId |
| onSuccess | a callback executed when Timeline request success. |
| onError | a callback executed when timeline fetch fails. It invokes with a String explaining the error |



#### See also


| |
|---|
| [MCLSNetwork.getTimelineActions](get-timeline-actions.html) |
| AnnotationAction |



