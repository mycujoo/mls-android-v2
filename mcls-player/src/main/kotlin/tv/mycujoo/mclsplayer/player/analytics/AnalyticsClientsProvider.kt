package tv.mycujoo.mclsplayer.player.analytics

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AnalyticsClientsProvider @Inject constructor() {
    private val analyticsClientList = mutableSetOf<AnalyticsClient>()

    fun getClients(): List<AnalyticsClient> {
        return analyticsClientList.toList()
    }

    fun addClient(analyticsClient: AnalyticsClient) {
        analyticsClientList.add(analyticsClient)
    }

    fun removeClient(analyticsClient: AnalyticsClient) {
        analyticsClientList.remove(analyticsClient)
    }
}