package tv.mycujoo.mclsnetwork.domain.params

data class EventListParams(
    val pageSize: Int? = null,
    val pageToken: String? = null,
    val filter: String? = null,
    val orderBy: String? = null
)