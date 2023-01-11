package tv.mycujoo.mclsplayer.player

import android.os.Looper
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.PlaybackParameters
import com.google.android.exoplayer2.Timeline
import com.google.android.exoplayer2.Tracks
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

fun getMockExoPlayer(): ExoPlayer {
    val exoPlayer = mock<ExoPlayer>()
    val currentTimeLine = mock<Timeline>()
    val playbackParameters = PlaybackParameters(1f)

    whenever(exoPlayer.playbackParameters)
        .thenReturn(playbackParameters)

    whenever(exoPlayer.applicationLooper)
        .thenReturn(Looper.getMainLooper())

    whenever(exoPlayer.currentTracks)
        .thenReturn(Tracks(listOf()))

    whenever(exoPlayer.currentTimeline)
        .thenReturn(currentTimeLine)

    whenever(currentTimeLine.windowCount)
        .thenReturn(0)

    return exoPlayer
}