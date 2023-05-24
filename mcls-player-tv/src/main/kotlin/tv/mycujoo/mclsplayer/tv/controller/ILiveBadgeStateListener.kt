package tv.mycujoo.mclsplayer.tv.controller

import tv.mycujoo.mclsplayercore.entity.LiveState


interface ILiveBadgeStateListener {
    fun setState(state: LiveState)
}