package tv.mycujoo.mcls.widget

import android.app.Activity
import com.google.android.exoplayer2.ExoPlayer
import com.npaw.youbora.lib6.YouboraLog
import com.npaw.youbora.lib6.exoplayer2.Exoplayer2Adapter
import com.npaw.youbora.lib6.plugin.Options
import com.npaw.youbora.lib6.plugin.Plugin
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclscore.logger.MessageLevel
import tv.mycujoo.mclscore.model.EventEntity
import tv.mycujoo.mclsplayer.player.analytics.AnalyticsClient

class YouboraAnalyticsClient(
    activity: Activity,
    exoPlayer: ExoPlayer,
    accountCode: String,
    deviceType: String,
    private val pseudoUserId: String,
    var videoAnalyticsCustomData: VideoAnalyticsCustomData? = null,
    private var logger: Logger = Logger(),
) : AnalyticsClient {

    private var plugin: Plugin? = null

    init {
        val youboraOptions = Options()
        youboraOptions.accountCode = accountCode
        youboraOptions.isAutoDetectBackground = true

        youboraOptions.deviceCode = deviceType

        plugin = Plugin(youboraOptions, activity.baseContext)

        plugin?.activity = activity
        plugin?.adapter = Exoplayer2Adapter(exoPlayer)

        when (logger.getLogLevel()) {
            LogLevel.MINIMAL -> {
                YouboraLog.setDebugLevel(YouboraLog.Level.SILENT)
            }
            LogLevel.INFO -> {
                YouboraLog.setDebugLevel(YouboraLog.Level.DEBUG)
            }
            LogLevel.VERBOSE -> {
                YouboraLog.setDebugLevel(YouboraLog.Level.VERBOSE)
            }
        }
    }

    override fun start() {
        TODO("Not yet implemented")
    }

    override fun stop() {
        TODO("Not yet implemented")
    }

    override fun logEvent(eventEntity: EventEntity) {
        val savedPlugin = plugin
        if (savedPlugin == null) {
            logger.log(MessageLevel.ERROR, "Please Set Plugin Before Logging Event!!")
            return
        }
        savedPlugin.options.username = pseudoUserId
        savedPlugin.options.contentTitle = eventEntity.title
        savedPlugin.options.contentResource = eventEntity.streams.firstOrNull()?.toString()

        savedPlugin.options.contentCustomDimension2 = eventEntity.id

        savedPlugin.options.contentCustomDimension14 = getVideoSource(eventEntity)
        savedPlugin.options.contentCustomDimension15 = eventEntity.streams.firstOrNull()?.id

        videoAnalyticsCustomData?.let {
            savedPlugin.options.contentCustomDimension1 = it.contentCustomDimension1
            savedPlugin.options.contentCustomDimension3 = it.contentCustomDimension3
            savedPlugin.options.contentCustomDimension4 = it.contentCustomDimension4
            savedPlugin.options.contentCustomDimension5 = it.contentCustomDimension5
            savedPlugin.options.contentCustomDimension6 = it.contentCustomDimension6
            savedPlugin.options.contentCustomDimension7 = it.contentCustomDimension7
            savedPlugin.options.contentCustomDimension8 = it.contentCustomDimension8
            savedPlugin.options.contentCustomDimension9 = it.contentCustomDimension9
            savedPlugin.options.contentCustomDimension10 = it.contentCustomDimension10
            savedPlugin.options.contentCustomDimension11 = it.contentCustomDimension11
            savedPlugin.options.contentCustomDimension12 = it.contentCustomDimension12
            savedPlugin.options.contentCustomDimension13 = it.contentCustomDimension13
        }
    }

    /**region Internal*/
    private fun getVideoSource(event: EventEntity): String {
        return if (event.isMLS) {
            MLS_SOURCE
        } else {
            NONE_NATIVE_SOURCE
        }
    }

    /**endregion */

    companion object {
        const val MLS_SOURCE = "MLS"
        const val NONE_NATIVE_SOURCE = "NonNativeMLS"
    }
}