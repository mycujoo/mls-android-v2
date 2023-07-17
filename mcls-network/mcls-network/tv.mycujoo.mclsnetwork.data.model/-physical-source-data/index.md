---
title: PhysicalSourceData
---
//[mcls-network](../../../index.html)/[tv.mycujoo.mclsnetwork.data.model](../index.html)/[PhysicalSourceData](index.html)



# PhysicalSourceData



[androidJvm]\
@JsonClass(generateAdapter = true)



data class [PhysicalSourceData](index.html)(val city: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val continent_code: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val coordinates: [CoordinatesSourceData](../-coordinates-source-data/index.html)? = null, val country_code: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, val venue: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;)



## Constructors


| | |
|---|---|
| [PhysicalSourceData](-physical-source-data.html) | [androidJvm]<br>constructor(city: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, continent_code: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, coordinates: [CoordinatesSourceData](../-coordinates-source-data/index.html)? = null, country_code: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;, venue: [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) = &quot;&quot;) |


## Properties


| Name | Summary |
|---|---|
| [city](city.html) | [androidJvm]<br>@Json(name = &quot;city&quot;)<br>val [city](city.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [continent_code](continent_code.html) | [androidJvm]<br>@Json(name = &quot;continentCode&quot;)<br>val [continent_code](continent_code.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [coordinates](coordinates.html) | [androidJvm]<br>@Json(name = &quot;coordinates&quot;)<br>val [coordinates](coordinates.html): [CoordinatesSourceData](../-coordinates-source-data/index.html)? = null |
| [country_code](country_code.html) | [androidJvm]<br>@Json(name = &quot;countryCode&quot;)<br>val [country_code](country_code.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |
| [venue](venue.html) | [androidJvm]<br>@Json(name = &quot;venue&quot;)<br>val [venue](venue.html): [String](https://kotlinlang.org/api/latest/jvm/stdlib/kotlin/-string/index.html) |

