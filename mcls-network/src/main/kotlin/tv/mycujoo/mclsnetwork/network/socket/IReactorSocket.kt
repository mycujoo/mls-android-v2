package tv.mycujoo.mclsnetwork.network.socket

import tv.mycujoo.mclsnetwork.model.JoinTimelineParam

interface IReactorSocket {

    fun addListener(reactorCallback: ReactorCallback)

    fun joinEvent(eventId: String)
    fun leave(destroyAfter: Boolean)
    fun joinTimeline(param: JoinTimelineParam)
}
