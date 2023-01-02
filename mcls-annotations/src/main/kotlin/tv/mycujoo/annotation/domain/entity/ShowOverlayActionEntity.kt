package tv.mycujoo.annotation.domain.entity

import tv.mycujoo.mclscore.entity.AnimationType
import tv.mycujoo.mclscore.model.PositionGuide
import java.io.InputStream

data class ShowOverlayActionEntity(
    val id: String,
    val customId: String?,
    val svgInputStream: InputStream?,
    val positionGuide: PositionGuide,
    val size: Pair<Float, Float>,
    val duration: Long?,
    val introAnimationType: AnimationType,
    val introAnimationDuration: Long,
    val outroAnimationType: AnimationType,
    val outroAnimationDuration: Long
)
