package tv.mycujoo.mclscore.model

import tv.mycujoo.mclscore.entity.AnimationType

data class TransitionSpec(
    val offset: Long,
    val animationType: AnimationType,
    val animationDuration: Long
)
