package tv.mycujoo.mclsnetwork.data

import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.MCLSResult
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclscore.logger.LogLevel

interface IInternalDataProvider {

    suspend fun getActions(
        timelineId: String,
        updateId: String? = null
    ): MCLSResult<Exception, List<AnnotationAction>>

    suspend fun getEventDetails(
        eventId: String,
        updateId: String? = null
    ): MCLSResult<Exception, EventEntity>

    fun setLogLevel(logLevel: LogLevel)
}
