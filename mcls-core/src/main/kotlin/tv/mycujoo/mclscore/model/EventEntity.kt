package tv.mycujoo.mclscore.model

import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.entity.ServerConstants.Companion.ERROR_CODE_GEOBLOCKED
import tv.mycujoo.mclscore.entity.ServerConstants.Companion.ERROR_CODE_NO_ENTITLEMENT
import tv.mycujoo.mclscore.entity.ServerConstants.Companion.ERROR_CODE_UNSPECIFIED
import tv.mycujoo.mclscore.entity.StreamStatus
import tv.mycujoo.mclscore.helper.DateTimeHelper
import java.util.*

/**
 *
 * This data class is used to represent the MCLS Event data type.
 * We are using this class as the base of communication between MCLS Player, MCLS Network to protect the SDKs from
 * future JSON changes inside the API.
 *
 * @param id Event Id
 * @param title Event Title
 * @param description Event Description
 * @param thumbnailUrl Event Thumbnail
 * @param poster_url Event Poster URL
 * @param location Event Geo-Location
 * @param organiser Event Organizer
 * @param start_time Event Time, we are using Calendar to represent time in Java to minimize dependencies
 * @param status Event Status, @see EventStatus
 * @param streams List Of Stream Object that represents the links the player can play.
 * @param timezone Timezone
 * @param timeline_ids List of Ids can be used to pull annotation actions.
 * @param metadata Generic Metadata Holder
 * @param is_test an indication if this is a test event
 * @param isMLS is used to indicate when the Event is Factored in-code, so we don't pull updates to override this stream and event.
 * @param is_protected
 */
data class EventEntity(
    val id: String,
    val title: String,
    val description: String?,
    val thumbnailUrl: String?,
    val poster_url: String?,
    val location: Location?,
    val organiser: String?,
    val start_time: Calendar?,
    val status: EventStatus,
    val streams: List<Stream>,
    val timezone: String?,
    val timeline_ids: List<String>,
    val metadata: Metadata?,
    val is_test: Boolean,
    val isMLS: Boolean = true,
    val is_protected: Boolean = false
) {
    fun streamStatus(): StreamStatus {
        if (streams.isEmpty()) {
            return StreamStatus.NO_STREAM_URL
        }
        val stream = streams[0]
        if (stream.hasError()) {
            if (stream.isGeoBlocked()) {
                return StreamStatus.GEOBLOCKED
            }
            if (stream.isNoEntitlement()) {
                return StreamStatus.NO_ENTITLEMENT
            }
            return StreamStatus.UNKNOWN_ERROR
        }

        if (stream.isStreamPlayable()) {
            return StreamStatus.PLAYABLE
        }

        return StreamStatus.UNKNOWN_ERROR
    }

    fun getFormattedStartTimeDate(locale: Locale?): String? {
        start_time?.let { return DateTimeHelper.formatDatetime(it, locale) }
        return null
    }
}

data class Stream(
    val id: String,
    val dvrWindowString: String?,
    val fullUrl: String?,
    val widevine: Widevine?,
    val errorCodeAndMessage: Err? = null
) {
    fun getDvrWindowSize(): Long {
        if (dvrWindowString == null) {
            return Long.MAX_VALUE
        }
        return try {
            dvrWindowString.toLong()
        } catch (e: Exception) {
            Long.MAX_VALUE
        }
    }

    fun isStreamPlayable(): Boolean {
        return isStreamRawPlayable(this) ||
                isStreamWidevinePlayable(this)
    }

    fun hasError(): Boolean {
        return errorCodeAndMessage?.code.isNullOrEmpty().not()
    }

    fun isGeoBlocked(): Boolean {
        errorCodeAndMessage?.let {
            if (it.code == ERROR_CODE_GEOBLOCKED) {
                return true
            }
        }
        return false
    }

    fun isNoEntitlement(): Boolean {
        if (errorCodeAndMessage?.code == ERROR_CODE_NO_ENTITLEMENT) {
            return true
        }
        return false
    }

    fun hasUnknownError(): Boolean {
        if (errorCodeAndMessage?.code == ERROR_CODE_UNSPECIFIED) {
            return true
        }
        return false
    }

    private fun isStreamRawPlayable(stream: Stream): Boolean {
        return stream.fullUrl.isNullOrEmpty().not()
    }

    private fun isStreamWidevinePlayable(stream: Stream): Boolean {
        stream.widevine?.let { widevine ->
            return widevine.licenseUrl.isNullOrEmpty().not() &&
                    widevine.fullUrl.isNullOrEmpty().not()
        }
        return false
    }
}


data class Widevine(
    val fullUrl: String?,
    val licenseUrl: String?
)

data class Err(
    val code: String?,
    val message: String?
)

data class Location(
    val physical: Physical
)

class Metadata(
)

data class Physical(
    val city: String,
    val continent_code: String,
    val coordinates: Coordinates,
    val country_code: String,
    val venue: String
)

data class Coordinates(
    val latitude: Double,
    val longitude: Double
)

