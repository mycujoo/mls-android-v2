package tv.mycujoo.mclsnetwork.factory

import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclscore.model.Location
import tv.mycujoo.mclscore.model.Metadata
import tv.mycujoo.mclscore.model.Stream
import java.util.Calendar

object EventFactory {

    fun getEvent(
        id: String = "1",
        title: String = "Event Title",
        description: String? = null,
        thumbnailUrl: String? = null,
        poster_url: String? = null,
        location: Location? = null,
        organiser: String? = null,
        start_time: Calendar? = null,
        status: EventStatus = EventStatus.EVENT_STATUS_SCHEDULED,
        streams: List<Stream> = emptyList(),
        timezone: String? = null,
        timeline_ids: List<String> = emptyList(),
        metadata: Metadata? = null,
        is_test: Boolean = true,
    ) = MCLSEvent(
        id,
        title,
        description,
        thumbnailUrl,
        poster_url,
        location,
        organiser,
        start_time,
        status,
        streams,
        timezone,
        timeline_ids,
        metadata,
        is_test
    )
}