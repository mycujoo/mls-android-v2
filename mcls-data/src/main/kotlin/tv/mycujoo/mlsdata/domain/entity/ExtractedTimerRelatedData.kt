package tv.mycujoo.mlsdata.domain.entity

import tv.mycujoo.mclscore.entity.ScreenTimerDirection
import tv.mycujoo.mclscore.entity.ScreenTimerFormat

/**
 * Extracted data needed to create a Timer related action. i.e. CreateTimer action.
 */
data class ExtractedTimerRelatedData(
    val name: String,
    val format: ScreenTimerFormat,
    val direction: ScreenTimerDirection,
    val startValue: Long,
    val step: Long,
    val capValue: Long,
    val value: Long
) {
}
