---
title: getEventList
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork](../index.html)/[MCLSNetworkImpl](index.html)/[getEventList](get-event-list.html)



# getEventList



[androidJvm]\
open suspend override fun [getEventList](get-event-list.html)(pageSize: [Int](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-int/index.html)?, pageToken: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, filter: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html)?, orderBy: [OrderByEventsParam](../../tv.mycujoo.mclsnetwork.domain.entity/-order-by-events-param/index.html)?): MCLSResult&lt;[Exception](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-exception/index.html), Events&gt;



Fetches Events List and Returns them in a MCLSResult wrapper



#### Return



the response of the call



#### Parameters


androidJvm

| | |
|---|---|
| pageSize | the number of items wanted in a given response |
| pageToken | used for pagination purposes |
| filter | used for filtering events based on a given query. |
| orderBy | the order of the event list |



#### See also


| | |
|---|---|
| MCLSResult | For more information about the filter query please refer to the following {@link <a href="https://mcls.mycujoo.tv/api-docs/#list-events">https://mcls.mycujoo.tv/api-docs/#list-events} |



