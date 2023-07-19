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
data class MCLSEvent(
    val id: String,
    val title: String,
    val description: String?,
    val thumbnailUrl: String?,
    val poster_url: String?,
    val location: Physical?,
    val organiser: String?,
    val start_time: Calendar?,
    val status: EventStatus,
    val streams: List<MCLSStream>,
    val timezone: String?,
    val timeline_ids: List<String>,
    val metadata: Metadata?,
    val is_test: Boolean,
    val isMLS: Boolean = true,
    val is_protected: Boolean = false
) {

    fun getFormattedStartTimeDate(locale: Locale?): String? {
        start_time?.let { return DateTimeHelper.formatDatetime(it, locale) }
        return null
    }
}

data class MCLSStream(
    val id: String,
    val dvrWindowString: String?,
    val fullUrl: String?,
    val widevine: Widevine?,
    val err: Err? = null
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
        return err?.code.isNullOrEmpty().not()
    }

    fun isGeoBlocked(): Boolean {
        err?.let {
            if (it.code == ERROR_CODE_GEOBLOCKED) {
                return true
            }
        }
        return false
    }

    fun isNoEntitlement(): Boolean {
        if (err?.code == ERROR_CODE_NO_ENTITLEMENT) {
            return true
        }
        return false
    }

    fun hasUnknownError(): Boolean {
        if (err?.code == ERROR_CODE_UNSPECIFIED) {
            return true
        }
        return false
    }

    private fun isStreamRawPlayable(stream: MCLSStream): Boolean {
        return stream.fullUrl.isNullOrEmpty().not()
    }

    private fun isStreamWidevinePlayable(stream: MCLSStream): Boolean {
        stream.widevine?.let { widevine ->
            return widevine.licenseUrl.isNullOrEmpty().not() &&
                    widevine.fullUrl.isNullOrEmpty().not()
        }
        return false
    }

    fun streamStatus(): StreamStatus {
        if (hasError()) {
            if (isGeoBlocked()) {
                return StreamStatus.GEOBLOCKED
            }
            if (isNoEntitlement()) {
                return StreamStatus.NO_ENTITLEMENT
            }
            return StreamStatus.UNKNOWN_ERROR
        }

        if (isStreamPlayable()) {
            return StreamStatus.PLAYABLE
        }

        return StreamStatus.UNKNOWN_ERROR
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

class Metadata(
)

data class Physical(
    val city: String,
    val continent_code: String,
    val coordinates: Coordinates?,
    val country_code: String,
    val venue: String
)

data class Coordinates(
    val latitude: Double,
    val longitude: Double
)

