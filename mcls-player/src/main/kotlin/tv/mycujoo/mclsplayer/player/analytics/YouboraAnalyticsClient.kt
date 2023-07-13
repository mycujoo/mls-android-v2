package tv.mycujoo.mclsplayer.player.analytics

import android.app.Activity
import android.content.pm.PackageManager
import com.npaw.youbora.lib6.YouboraLog
import com.npaw.youbora.lib6.exoplayer2.Exoplayer2Adapter
import com.npaw.youbora.lib6.plugin.Options
import com.npaw.youbora.lib6.plugin.Plugin
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclscore.model.MCLSEvent
import tv.mycujoo.mclsplayer.player.di.YouboraAccountCode
import tv.mycujoo.mclsplayer.player.user.UserPrefs
import tv.mycujoo.mclsplayer.player.utils.ExoPlayerContainer
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class YouboraAnalyticsClient @Inject constructor(
    val activity: Activity,
    val exoPlayerContainer: ExoPlayerContainer,
    @YouboraAccountCode val accountCode: String,
    private val logger: Logger,
    private val user: UserPrefs,
) {

    private var plugin: Plugin? = null

    var videoAnalyticsCustomData: VideoAnalyticsCustomData? = null

    fun initialize() {
        val youboraOptions = Options()
        youboraOptions.accountCode = accountCode
        youboraOptions.isAutoDetectBackground = true

        if (activity.packageManager.hasSystemFeature(PackageManager.FEATURE_LEANBACK)) {
            youboraOptions.deviceCode = "AndroidTV"
        } else {
            youboraOptions.deviceCode = "Android"
        }

        plugin = Plugin(youboraOptions, activity.baseContext)

        plugin?.activity = activity

        exoPlayerContainer.exoPlayer?.let { exoPlayer ->
            plugin?.adapter = Exoplayer2Adapter(exoPlayer)
        }

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

    fun setup(videoAnalyticsCustomData: VideoAnalyticsCustomData) {
        this.videoAnalyticsCustomData = videoAnalyticsCustomData
    }

    fun logEvent(MCLSEvent: MCLSEvent) {
        val savedPlugin = plugin ?: return
        savedPlugin.options.username = user.getPseudoUserId()
        savedPlugin.options.contentTitle = MCLSEvent.title
        savedPlugin.options.contentResource = MCLSEvent.streams.firstOrNull()?.toString()

        savedPlugin.options.contentCustomDimension2 = MCLSEvent.id

        savedPlugin.options.contentCustomDimension12 = user.getUserId().orEmpty().ifEmpty {
            user.getPseudoUserId()
        }

        savedPlugin.options.contentCustomDimension14 = getVideoSource(MCLSEvent)
        savedPlugin.options.contentCustomDimension15 = MCLSEvent.streams.firstOrNull()?.id

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
            savedPlugin.options.contentCustomDimension13 = it.contentCustomDimension13
        }
    }

    /**region Internal*/
    private fun getVideoSource(event: MCLSEvent): String {
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