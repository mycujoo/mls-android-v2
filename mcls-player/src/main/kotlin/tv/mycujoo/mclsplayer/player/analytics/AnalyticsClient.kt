package tv.mycujoo.mclsplayer.player.analytics

import tv.mycujoo.mclscore.model.EventEntity

interface AnalyticsClient {

    fun start()

    fun stop()

    fun logEvent(eventEntity: EventEntity)
}