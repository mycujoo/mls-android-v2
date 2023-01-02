package tv.mycujoo.mclscore.model

data class Events(
    val eventEntities: List<EventEntity>,
    val previousPageToken: String?,
    val nextPageToken: String?
)
