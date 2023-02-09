package tv.mycujoo.mclscore.model

/**
 * Used as a safe representation of the event list MCLS request.
 *
 * @param eventEntities List of entities
 * @param previousPageToken A token to go back in pagination
 * @param nextPageToken A token to go forward in pagination
 */
data class Events(
    val eventEntities: List<MCLSEvent>,
    val previousPageToken: String?,
    val nextPageToken: String?
)
