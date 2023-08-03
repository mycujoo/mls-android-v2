package tv.mycujoo.mclscore.model

import org.amshove.kluent.`should not be`
import org.amshove.kluent.shouldNotBeNull
import org.junit.Assert.assertTrue
import org.junit.Test
import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.entity.ServerConstants.Companion.ERROR_CODE_GEOBLOCKED
import tv.mycujoo.mclscore.entity.ServerConstants.Companion.ERROR_CODE_NO_ENTITLEMENT
import tv.mycujoo.mclscore.entity.ServerConstants.Companion.ERROR_CODE_UNSPECIFIED
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class MCLSEventTest {


    @Test
    fun `given stream with raw resource, should return true`() {
        assertTrue(regularStream().isStreamPlayable())
    }

    @Test
    fun `event with valid date, return valid formattedStartDate`() {
        val formattedStartTimeDate = eventWithStartDate().getFormattedStartTimeDate(Locale.ENGLISH)
        formattedStartTimeDate `should not be` null
    }

    @Test
    fun `event with no date, returns null as formattedStartDate`() {
        event(emptyList()).getFormattedStartTimeDate(Locale.ENGLISH)?.shouldNotBeNull()
    }

    companion object {
        fun regularStream() = MCLSStream("stream_id", Long.MAX_VALUE.toString(), "sample_url", null)
        fun geoBlockedStream() = MCLSStream(
            id = "stream_id",
            dvrWindowString = Long.MAX_VALUE.toString(),
            fullUrl = null,
            widevine = null,
            err = Err(ERROR_CODE_GEOBLOCKED, null)
        )

        fun noEntitlementStream() = MCLSStream(
            id = "stream_id",
            dvrWindowString = Long.MAX_VALUE.toString(),
            fullUrl = null,
            widevine = null,
            err = Err(ERROR_CODE_NO_ENTITLEMENT, null)
        )

        fun unknownErrorStream() = MCLSStream(
            id = "stream_id",
            dvrWindowString = Long.MAX_VALUE.toString(),
            fullUrl = null,
            widevine = null,
            err = Err(ERROR_CODE_UNSPECIFIED, null)
        )

        fun emptyErrorStream() = MCLSStream(
            id = "stream_id",
            dvrWindowString = Long.MAX_VALUE.toString(),
            fullUrl = null,
            widevine = null,
            err = Err(null, null)
        )

        fun eawVideo(): MCLSEvent {
            return event(listOf())
        }

        fun eventWithNoStream(): MCLSEvent {
            return event(emptyList())
        }

        fun eventWithWidevineVideo(): MCLSEvent {
            return event(listOf(widevineStream()))
        }

        fun widevineStream(): MCLSStream {
            val widevine = Widevine("sample_url", "license_url")
            return MCLSStream("stream_id", Long.MAX_VALUE.toString(), null, widevine)
        }

        private fun event(streams: List<MCLSStream>): MCLSEvent {
            val location = Physical(
                "",
                "",
                Coordinates(0.toDouble(), 0.toDouble()),
                "",
                ""
            )
            val event = MCLSEvent(
                "event_id_0",
                "event_title",
                "event_desc",
                "",
                null,
                location,
                "",
                null,
                EventStatus.EVENT_STATUS_FINISHED,
                streams,
                "",
                emptyList(),
                Metadata(),
                false
            )

            return event
        }

        private fun eventWithStartDate(): MCLSEvent {
            val location = Physical(
                "",
                "",
                Coordinates(0.toDouble(), 0.toDouble()),
                "",
                ""
            )

            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss")
            val date = sdf.parse("2020-07-11T07:32:46Z")
            val cal = Calendar.getInstance()
            cal.time = date

            return MCLSEvent(
                "event_id_0",
                "event_title",
                "event_desc",
                "",
                null,
                location,
                "",
                cal,
                EventStatus.EVENT_STATUS_FINISHED,
                emptyList(),
                "",
                emptyList(),
                Metadata(),
                false
            )
        }
    }

}