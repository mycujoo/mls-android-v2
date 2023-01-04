package tv.mycujoo.mclsnetwork.data

import tv.mycujoo.mclscore.model.Action
import tv.mycujoo.mclscore.model.Result
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclsnetwork.enum.LogLevel

interface IInternalDataProvider {

    suspend fun getActions(
        timelineId: String,
        updateId: String? = null
    ): Result<Exception, List<Action>>

    suspend fun getEventDetails(
        eventId: String,
        updateId: String? = null
    ): Result<Exception, EventEntity>

    fun setLogLevel(logLevel: LogLevel)
}
