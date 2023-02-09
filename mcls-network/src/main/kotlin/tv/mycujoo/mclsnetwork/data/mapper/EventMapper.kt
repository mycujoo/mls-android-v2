package tv.mycujoo.mclsnetwork.data.mapper

import tv.mycujoo.mclscore.entity.EventStatus
import tv.mycujoo.mclscore.model.*
import tv.mycujoo.mclsnetwork.data.model.*
import java.text.SimpleDateFormat
import java.util.*

class EventMapper {
    companion object {
        fun mapEventSourceDataToEventEntity(sourceData: EventSourceData): MCLSEvent {
            val location = mapLocationSourceDataToLocationEntity(sourceData.locationSourceData)
            val sdf = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            val date = sdf.parse(sourceData.start_time)?.let {
                val cal = Calendar.getInstance()
                cal.time = it
                cal
            }

            val eventStatus = EventStatus.fromValueOrUnspecified(sourceData.status)

            val streams = sourceData.streams.map { mapStreamSourceToStreamEntity(it) }
            val metaData = mapMetaDataSourceDataToMetaDataEntity(sourceData.metadata)

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

        private fun mapMetaDataSourceDataToMetaDataEntity(metadata: MetadataSourceData): Metadata {
            return Metadata()
        }

        private fun mapStreamSourceToStreamEntity(sourceData: StreamSourceData): Stream {
            val widevine = mapWidevineSourceDataToWidevineEntity(sourceData.drm?.widevine)
            val errorCodeAndMessage =
                mapErrorCodeAndMessageSourceDataToErrorCodeAndMessageEntity(sourceData.errorCodeAndMessage)
            return Stream(
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


        private fun mapLocationSourceDataToLocationEntity(sourceData: LocationSourceData): Location {
            val physical = mapPhysicalSourceDataToPhysicalEntity(sourceData.physicalSourceData)
            return Location(physical)
        }

        private fun mapPhysicalSourceDataToPhysicalEntity(sourceData: PhysicalSourceData): Physical {
            val coordinates = mapCoordinatesSourceCodeToCoordinatesEntity(sourceData.coordinates)
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
    }
}
