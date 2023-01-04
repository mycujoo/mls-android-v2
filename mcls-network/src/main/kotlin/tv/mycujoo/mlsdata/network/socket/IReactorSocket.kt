package tv.mycujoo.mlsdata.network.socket

import tv.mycujoo.mlsdata.model.JoinTimelineParam

interface IReactorSocket {

    fun addListener(reactorCallback: ReactorCallback)

    fun joinEvent(eventId: String)
    fun leave(destroyAfter: Boolean)
    fun joinTimeline(param: JoinTimelineParam)
}
