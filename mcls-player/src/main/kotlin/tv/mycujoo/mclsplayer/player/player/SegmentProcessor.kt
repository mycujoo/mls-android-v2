package tv.mycujoo.mclsplayer.player.player

import com.google.android.exoplayer2.source.hls.playlist.HlsMediaPlaylist
import tv.mycujoo.mclsplayer.player.utils.MathUtils
import tv.mycujoo.mclsplayer.player.utils.StringUtils
import java.util.concurrent.CopyOnWriteArrayList
import javax.inject.Inject

class SegmentProcessor @Inject constructor() : ISegmentProcessor {
    private val dcSegmentsList = CopyOnWriteArrayList<Pair<Long, Long>>()
    private var windowStartTime = -1L

    override fun getDiscontinuityBoundaries(): CopyOnWriteArrayList<Pair<Long, Long>> {
        return dcSegmentsList
    }

    override fun getWindowStartTime(): Long {
        return windowStartTime
    }

    override fun process(segments: List<HlsMediaPlaylist.Segment>) {
        if (dcSegmentsList.isNotEmpty()) {
            dcSegmentsList.clear()
        }
        segments.forEachIndexed { index, segment ->
            if (index == 0) {
                val segmentTimeStamp = StringUtils.getSegmentTimeStamp(segment.url)
                windowStartTime = if (segmentTimeStamp != -1L) {
                    MathUtils.convertToEpochInMS(segmentTimeStamp.toLong())
                } else {
                    -1L
                }
            }
            if (segment.relativeDiscontinuitySequence > 0) {

                val segmentTimeStamp = StringUtils.getSegmentTimeStamp(segment.url)
                if (segmentTimeStamp != -1L &&
                    segment.durationUs != 0L
                ) {
                    val epochInMS = MathUtils.convertToEpochInMS(segmentTimeStamp)
                    var duration = segment.durationUs
                    duration /= 1000
                    dcSegmentsList.add(
                        Pair(
                            epochInMS,
                            duration
                        )
                    )
                }
            }
        }
    }

    override fun clear() {
        dcSegmentsList.clear()
    }
}
