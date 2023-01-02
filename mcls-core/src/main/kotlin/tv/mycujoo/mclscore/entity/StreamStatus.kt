package tv.mycujoo.mclscore.entity

/**
 * Stream may have different status based on user location and entitlement
 */
enum class StreamStatus {
    NO_STREAM_URL,
    PLAYABLE,
    GEOBLOCKED,
    NO_ENTITLEMENT,
    UNKNOWN_ERROR
}