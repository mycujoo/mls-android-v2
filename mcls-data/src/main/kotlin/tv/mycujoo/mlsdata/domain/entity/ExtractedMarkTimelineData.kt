package tv.mycujoo.mlsdata.domain.entity

/**
 * Extracted data needed to create a ShowTimelineMarker
 */
data class ExtractedMarkTimelineData(
    val seekOffset: Long,
    val label: String,
    var color: String
)
