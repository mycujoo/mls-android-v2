package tv.mycujoo.mclsplayer.player.mediator

import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclsplayercore.config.VideoPlayerConfig

interface VideoPlayerMediator {
    fun setConfig(config: VideoPlayerConfig)

    fun playEvent(event: MCLSEvent)

    fun currentPosition(): Long
}