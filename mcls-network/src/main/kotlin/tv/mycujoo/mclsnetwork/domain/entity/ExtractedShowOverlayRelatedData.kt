package tv.mycujoo.mclsnetwork.domain.entity

import tv.mycujoo.mclscore.model.PositionGuide

/**
 * Extracted data needed to create a ShowOverlay action
 */
data class ExtractedShowOverlayRelatedData(
    val customId: String?,
    val svgUrl: String,
    val duration: Long?,
    val positionGuide: PositionGuide,
    val sizePair: Pair<Float, Float>,
    val introAnimationType: tv.mycujoo.mclscore.entity.AnimationType,
    val introAnimationDuration: Long,
    val outroAnimationType: tv.mycujoo.mclscore.entity.AnimationType,
    val outroAnimationDuration: Long,
    val variablePlaceHolders: List<String>
)
