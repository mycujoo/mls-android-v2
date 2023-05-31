---
title: getEventsList
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork](../index.html)/[MCLSNetworkImpl](index.html)/[getEventsList](get-events-list.html)



# getEventsList



[androidJvm]\
open suspend override fun [getEventsList](get-events-list.html)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, filter: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.html)?, fetchEventCallback: (eventList: [List](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin.collections/-list/index.html)&lt;MCLSEventListItem&gt;, previousPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html), nextPageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)) -&gt; [Unit](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-unit/index.html)?)



Fetches Events List and Returns them in a callback param



#### Parameters


androidJvm

| | |
|---|---|
| pageSize | the number of items wanted in a given response |
| pageToken | used for pagination purposes |
| filter | used for filtering events based on a given query. |
| orderBy | the order of the event list<br>For more information about the filter and the order by params queries please refer to the following {@link <a href="https://mcls.mycujoo.tv/api-docs/#list-events">https://mcls.mycujoo.tv/api-docs/#list-events} |




