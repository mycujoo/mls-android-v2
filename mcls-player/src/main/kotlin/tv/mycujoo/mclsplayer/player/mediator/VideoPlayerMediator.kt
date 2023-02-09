package tv.mycujoo.mclsplayer.player.mediator

import tv.mycujoo.mclscore.model.MCLSEvent

interface VideoPlayerMediator {
    fun playEvent(event: MCLSEvent)

    fun currentPosition(): Long
}