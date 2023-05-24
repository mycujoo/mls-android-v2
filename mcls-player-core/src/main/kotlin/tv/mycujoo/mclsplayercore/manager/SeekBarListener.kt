package tv.mycujoo.mclsplayercore.manager

import tv.mycujoo.mclsplayercore.model.PositionedPointOfInterest

interface SeekBarListener {
    fun onSeekTo(
        position: Int,
        positionedPointOfInterestList: ArrayList<PositionedPointOfInterest>
    )
}