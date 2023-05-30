package tv.mycujoo.mclsnetwork.network.socket

import tv.mycujoo.mclsnetwork.model.JoinTimelineParam

/**
 * Network Socket for event/timeline updates
 */
interface IReactorSocket {

    /**
     * Adds a listener to event updates. Those changes are only triggered after an event is joined via [joinEvent]
     *
     * @param reactorCallback a callback interface used to inform the user about event/annotation actions timeline updates
     */
    fun addListener(reactorCallback: ReactorCallback)

    /**
     * Joins the event updates by id
     *
     * @param eventId
     */
    fun joinEvent(eventId: String)

    /**
     * Leaves the socket, terminates the connections and releases resources (if leave(true)).
     */
    fun leave(destroyAfter: Boolean)

    /**
     * Joins timeline updates
     *
     * @param param
     */
    fun joinTimeline(param: JoinTimelineParam)
}
