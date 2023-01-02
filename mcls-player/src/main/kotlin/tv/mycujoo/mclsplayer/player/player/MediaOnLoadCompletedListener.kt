package tv.mycujoo.mclsplayer.player.player

import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.Timeline
import com.google.android.exoplayer2.source.LoadEventInfo
import com.google.android.exoplayer2.source.MediaLoadData
import com.google.android.exoplayer2.source.MediaSource
import com.google.android.exoplayer2.source.MediaSourceEventListener
import com.google.android.exoplayer2.source.hls.HlsManifest
import tv.mycujoo.mclsplayer.player.utils.ExoPlayerContainer
import java.util.concurrent.CopyOnWriteArrayList
import javax.inject.Inject

class MediaOnLoadCompletedListener @Inject constructor(
    private val exoPlayerContainer: ExoPlayerContainer,
    private val segmentProcessor: ISegmentProcessor
) : MediaSourceEventListener {

    private val exoPlayer: ExoPlayer
        get() = exoPlayerContainer.exoPlayer!!

    // For now we work with SECOND since that is provided in name of segments instead of MS
    fun getDiscontinuityBoundaries(): CopyOnWriteArrayList<Pair<Long, Long>> {
        return segmentProcessor.getDiscontinuityBoundaries()
    }

    fun getWindowStartTime(): Long {
        return segmentProcessor.getWindowStartTime()
    }

    override fun onLoadCompleted(
        windowIndex: Int,
        mediaPeriodId: MediaSource.MediaPeriodId?,
        loadEventInfo: LoadEventInfo,
        mediaLoadData: MediaLoadData
    ) {
        super.onLoadCompleted(windowIndex, mediaPeriodId, loadEventInfo, mediaLoadData)

        if (exoPlayer.currentTimeline.windowCount > 0) {
            val window = Timeline.Window()
            exoPlayer.currentTimeline.getWindow(0, window)
            if (window.manifest is HlsManifest) {
                (window.manifest as HlsManifest).mediaPlaylist.segments.let {
                    segmentProcessor.process(it)
                }
            }
        } else {
            clear()
        }

    }

    fun clear() {
        segmentProcessor.clear()
    }
}