package tv.mycujoo.mclsnetwork.network.request

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GetEventDetailsRequest(
    @Json(name = "id") val eventId: String
)