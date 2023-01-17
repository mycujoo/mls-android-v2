package tv.mycujoo.mclsplayercore.model

data class PointOfInterest(
    val offset: Long,
    val seekOffset : Long,
    val title: String,
    val poiType: PointOfInterestType
)