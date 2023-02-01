---
title: fetchEvents
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.api](../index.html)/[DataManager](index.html)/[fetchEvents](fetch-events.html)



# fetchEvents



[androidJvm]\
open override fun [fetchEvents](fetch-events.html)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, eventStatus: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventStatus&gt;?, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.html)?, fetchEventCallback: (eventList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;EventEntity&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?)



fetch Events with given specification



Events Are pushed into the LiveData events and fetchEventCallback when fetch is done.



#### Parameters


androidJvm

| | |
|---|---|
| pageSize | nullable size of page |
| pageToken | nullable token of page |
| eventStatus | nullable statuses of returned Events |
| orderBy | nullable order of returned Events |
| fetchEventCallback | nullable callback which will may be used to navigate through paginated data |



