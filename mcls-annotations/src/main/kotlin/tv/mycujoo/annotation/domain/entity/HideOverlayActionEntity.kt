package tv.mycujoo.annotation.domain.entity

import tv.mycujoo.mclscore.entity.AnimationType

data class HideOverlayActionEntity(
    val id: String,
    val customId: String,
    val outroAnimationType: AnimationType,
    val outroAnimationDuration: Long
)
