package tv.mycujoo.mclscore.model

import tv.mycujoo.mclscore.entity.EventStatus
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
data class MCLSEventListItem(
    val id: String,
    val title: String,
    val description: String?,
    val thumbnailUrl: String?,
    val poster_url: String?,
    val location: Location?,
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
