package tv.mycujoo.mclscore.model

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Test
import tv.mycujoo.mclscore.entity.StreamStatus

class MCLSStreamTest {
    @Test
    fun `Stream dvrWindow size test`() {
        val streamWith120000DvrWindow = MCLSStream("id_00", "120000", null, null)
        val streamWith0DvrWindow = MCLSStream("id_00", "0", null, null)
        val streamWithInvalidDvrWindow = MCLSStream("id_00", "", null, null)


        assertEquals(120000L, streamWith120000DvrWindow.getDvrWindowSize())
        assertEquals(0L, streamWith0DvrWindow.getDvrWindowSize())
        assertEquals(Long.MAX_VALUE, streamWithInvalidDvrWindow.getDvrWindowSize())
    }

    @Test
    fun `non-GEOBLOCKED stream should return false for isGeoBlocked`() {
        val stream = MCLSStream("id_0", "120000", null, null)


        assertFalse(stream.isGeoBlocked())
    }

    @Test
    fun `GEOBLOCKED stream should return true for isGeoBlocked`() {
        val geoBlockedStream = MCLSStream(
            id = "id_0", dvrWindowString = "120000", fullUrl = null, widevine = null,
            err = Err(
                code = "ERROR_CODE_GEOBLOCKED",
                message = "This stream is Geo-blocked"
            )
        )

        assert(geoBlockedStream.isGeoBlocked())
    }

    @Test
    fun `regular stream should return false for isNoEntitlement`() {
        val stream = MCLSStream("id_0", "120000", null, null)


        assertFalse(stream.isNoEntitlement())
    }

    @Test
    fun `no-entitlement stream should return true for isNoEntitlement`() {
        val stream = MCLSStream(
            id = "id_0", dvrWindowString = "120000", fullUrl = null, widevine = null,
            err = Err(
                code = "ERROR_CODE_NO_ENTITLEMENT",
                message = "Access to this stream is restricted"
            )
        )


        assert(stream.isNoEntitlement())
    }

    @Test
    fun `regular stream should return false for hasUnknownError`() {
        val stream = MCLSStream("id_0", "120000", null, null)


        assertFalse(stream.hasUnknownError())
    }

    @Test
    fun `stream with unknown-error should return true for hasUnknownError`() {
        val streamWithUnknownError = MCLSStream(
            "id_0", "120000", null, null,
            err = Err(
                code = "ERROR_CODE_UNSPECIFIED",
                message = null
            )
        )


        assert(streamWithUnknownError.hasUnknownError())
    }

    @Test
    fun `status of event with GeoBlocked stream is GEOBLOCKED`() {
        assertEquals(
            StreamStatus.GEOBLOCKED, MCLSEventTest.geoBlockedStream().streamStatus()
        )
    }

    @Test
    fun `status of event with No-Entitlement stream is NO_ENTITLEMENT`() {
        assertEquals(
            StreamStatus.NO_ENTITLEMENT,
            MCLSEventTest.noEntitlementStream().streamStatus()
        )
    }

    @Test
    fun `status of event with unknown-error stream is UNKNOWN_ERROR`() {
        assertEquals(
            StreamStatus.UNKNOWN_ERROR,
            MCLSEventTest.unknownErrorStream().streamStatus()
        )
    }

    @Test
    fun `status of event with empty-error stream is UNKNOWN_ERROR`() {
        assertEquals(
            StreamStatus.UNKNOWN_ERROR,
            MCLSEventTest.emptyErrorStream().streamStatus()
        )
    }

    @Test
    fun `given event with widevine stream, should return PLAYABLE`() {
        assertEquals(
            StreamStatus.PLAYABLE,
            MCLSEventTest.widevineStream().streamStatus()
        )
    }
}