package tv.mycujoo.mclsext

import kotlinx.coroutines.*
import kotlinx.coroutines.flow.*
import tv.mycujoo.mclscore.model.Action
import tv.mycujoo.mlsdata.MCLSData

@OptIn(ExperimentalCoroutinesApi::class)
suspend fun MCLSData.fetchActionsByEventId(
    eventId: String
): Flow<List<Action>> {
    return getEventDetails(eventId)
        .flatMapLatest {
            val timelineId = it.timeline_ids.firstOrNull() ?: return@flatMapLatest flowOf(emptyList())

            getActions(timelineId, null)
        }
}