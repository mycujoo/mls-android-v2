package tv.mycujoo.mlsdata.domain.entity

/**
 * Extracted data needed to create a HideOverlayAction
 */
data class ExtractedHideOverlayRelatedData(
    val id: String,
    val outroAnimationType: tv.mycujoo.mclscore.entity.AnimationType,
    val outroAnimationDuration: Long
)
