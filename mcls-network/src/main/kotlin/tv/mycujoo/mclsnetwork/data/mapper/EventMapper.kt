package tv.mycujoo.mclsnetwork.data.mapper

import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.*
import tv.mycujoo.mclsnetwork.data.model.*
import java.text.SimpleDateFormat
import java.util.*

class EventMapper {
    companion object {
        fun mapEventSourceDataToEventEntity(sourceData: EventSourceData): MCLSEvent {
            val location = sourceData.physical?.let { mapPhysicalSourceDataToPhysicalEntity(it) }
            val date = parseDate(sourceData.start_time)

            val eventStatus = EventStatus.fromValueOrUnspecified(sourceData.status)

            val streams =
                sourceData.streams.map { mapStreamSourceToStreamEntity(it) }
            val metaData = sourceData.metadata?.let { mapMetaDataSourceDataToMetaDataEntity(it) }

            return MCLSEvent(
                id = sourceData.id,
                title = sourceData.title,
                description = sourceData.description,
                thumbnailUrl = sourceData.thumbnailUrl,
                poster_url = sourceData.poster_url,
                location = location,
                organiser = sourceData.organiser,
                start_time = date,
                status = eventStatus,
                streams = streams,
                timezone = sourceData.timezone,
                timeline_ids = sourceData.timeline_ids,
                metadata = metaData,
                is_test = sourceData.is_test,
                is_protected = sourceData.is_protected,
            )
        }

        fun mapEventSourceDataToEventListItem(sourceData: EventSourceData): MCLSEventListItem {
            val location = sourceData.physical?.let { mapPhysicalSourceDataToPhysicalEntity(it) }
            val date = parseDate(sourceData.start_time)

            val eventStatus = EventStatus.fromValueOrUnspecified(sourceData.status)

            val streams = sourceData.streams.map { mapStreamSourceToStreamEntity(it) }
            val metaData = sourceData.metadata?.let { mapMetaDataSourceDataToMetaDataEntity(it) }

            return MCLSEventListItem(
                id = sourceData.id,
                title = sourceData.title,
                description = sourceData.description,
                thumbnailUrl = sourceData.thumbnailUrl,
                poster_url = sourceData.poster_url,
                location = location,
                organiser = sourceData.organiser,
                start_time = date,
                status = eventStatus,
                streams = streams,
                timezone = sourceData.timezone,
                timeline_ids = sourceData.timeline_ids,
                metadata = metaData,
                is_test = sourceData.is_test,
                is_protected = sourceData.is_protected,
            )
        }

        private fun mapMetaDataSourceDataToMetaDataEntity(metadata: MetadataSourceData): Metadata {
            return Metadata()
        }

        private fun mapStreamSourceToStreamEntity(sourceData: StreamSourceData): MCLSStream {
            val widevine = mapWidevineSourceDataToWidevineEntity(sourceData.drm?.widevine)
            val errorCodeAndMessage =
                mapErrorCodeAndMessageSourceDataToErrorCodeAndMessageEntity(sourceData.errorCodeAndMessage)
            return MCLSStream(
                sourceData.id,
                sourceData.dvrWindowString,
                sourceData.fullUrl,
                widevine,
                errorCodeAndMessage
            )
        }

        private fun mapErrorCodeAndMessageSourceDataToErrorCodeAndMessageEntity(sourceData: ErrorCodeAndMessageSourceData?): Err? {
            if (sourceData?.code == null || sourceData.message == null) {
                return null
            }
            return Err(sourceData.code, sourceData.message)
        }

        private fun mapWidevineSourceDataToWidevineEntity(sourceData: WidevineSourceData?): Widevine? {
            if (sourceData?.fullUrl == null || sourceData.licenseUrl == null) {
                return null
            }
            return Widevine(sourceData.fullUrl, sourceData.licenseUrl)
        }

        private fun mapPhysicalSourceDataToPhysicalEntity(sourceData: PhysicalSourceData): Physical {
            val coordinates = sourceData.coordinates?.let {
                mapCoordinatesSourceCodeToCoordinatesEntity(
                    it
                )
            }
            return Physical(
                sourceData.city,
                sourceData.continent_code,
                coordinates,
                sourceData.country_code,
                sourceData.venue
            )
        }

        private fun mapCoordinatesSourceCodeToCoordinatesEntity(sourceData: CoordinatesSourceData): Coordinates {
            return Coordinates(sourceData.latitude, sourceData.longitude)
        }

        private fun parseDate(date: String): Calendar {
            val cal = Calendar.getInstance()

            val s1: Calendar? = try {
                val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
                val dateTime = sdf.parse(date)
                if (dateTime != null) {
                    cal.time = dateTime
                }
                cal
            } catch (e: Exception) {
                null
            }

            if (s1 != null) {
                return s1
            }

            val s2: Calendar? = try {
                val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'", Locale.getDefault())
                val dateTime = sdf.parse(date)
                if (dateTime != null) {
                    cal.time = dateTime
                }
                cal
            } catch (e: Exception) {
                null
            }

            if (s2 != null) {
                return s2
            }

            return cal
        }
    }
}
