package tv.mycujoo.mclsplayercore.model

import java.util.*

interface TimelineMarkerPosition {
    fun onScrubMove(
        position: Float,
        positionedPointOfInterestList: ArrayList<PositionedPointOfInterest>
    )

    fun onScrubStop()
}