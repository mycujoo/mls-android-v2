package tv.mycujoo.mclsplayer.player.mediator

import tv.mycujoo.mclscore.model.EventEntity

interface VideoPlayerMediator {
    fun playEvent(event: EventEntity)

    fun currentPosition(): Long
}