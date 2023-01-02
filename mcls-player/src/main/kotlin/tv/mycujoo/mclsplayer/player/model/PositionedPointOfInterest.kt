package tv.mycujoo.mclsplayer.player.model

import tv.mycujoo.mcls.widgets.mlstimebar.PointOfInterest

data class PositionedPointOfInterest(
    var positionOnScreen: Int,
    val pointOfInterest: PointOfInterest
)