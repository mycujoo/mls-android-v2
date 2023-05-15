package tv.mycujoo.mclsplayer.player.player

import android.os.Handler
import android.os.Looper
import com.google.android.exoplayer2.C
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.util.MimeTypes
import com.google.android.exoplayer2.util.Util
import tv.mycujoo.mclsplayer.player.consts.C.DRM_WIDEVINE
import tv.mycujoo.mclsplayer.player.ima.IImaContainer
import tv.mycujoo.mclsima.ImaCustomParams
import tv.mycujoo.mclsplayer.player.model.MediaDatum
import tv.mycujoo.mclsplayer.player.model.MediaFactory
import tv.mycujoo.mclsplayer.player.utils.ExoPlayerContainer
import javax.inject.Inject

class PlayerImpl @Inject constructor(
    private val exoPlayerContainer: ExoPlayerContainer,
    private val mediaFactory: MediaFactory,
    private val mediaOnLoadCompletedListener: MediaOnLoadCompletedListener,
    private val imaContainer: IImaContainer,
) : Player {

    /**
     * Latest window of playing, if video player is playing.
     * This value is invalid if there is no item being played
     */
    private var resumeWindow: Int = C.INDEX_UNSET

    /**
     * information of the item being played
     */
    private var mediaData: MediaDatum? = null

    /**
     * Current playback position, if video player is playing.
     * This value is invalid if there is no item being played
     */
    private var playbackPosition: Long = -1L

    /**
     * Latest resume position at playing, if video player is playing.
     * This value is invalid if there is no item being played
     */
    private var resumePosition: Long = C.INDEX_UNSET.toLong()

    override fun getExoPlayerInstance(): ExoPlayer? {
        return exoPlayerContainer.exoPlayer
    }

    override fun currentPosition(): Long {
        return exoPlayerContainer.exoPlayer?.currentPosition ?: 0
    }

    override fun isLive(): Boolean {
        return exoPlayerContainer.exoPlayer?.isCurrentMediaItemLive ?: false
    }

    override fun duration(): Long {
        return exoPlayerContainer.exoPlayer?.duration ?: 0
    }

    override fun clearQue() {
        exoPlayerContainer.exoPlayer?.clearMediaItems()
    }

    override fun pause() {
        exoPlayerContainer.exoPlayer?.pause()
    }

    override fun play(drmMediaData: MediaDatum.DRMMediaData) {
        val config = MediaItem.DrmConfiguration
            .Builder(Util.getDrmUuid(DRM_WIDEVINE)!!)
            .setLicenseUri(drmMediaData.licenseUrl)
            .build()

        val mediaItem = MediaItem.Builder()
            .setDrmConfiguration(config)
            .setUri(drmMediaData.fullUrl)
            .setMimeType(MimeTypes.APPLICATION_M3U8)
            .build()

        play(mediaItem, drmMediaData.autoPlay)
    }

    override fun play(mediaData: MediaDatum.MediaData) {
        this.mediaData = mediaData
        val mediaItem = mediaFactory
            .createMediaItem(mediaData.fullUrl)
        play(mediaItem, mediaData.autoPlay)
    }

    override fun seekTo(position: Long) {
        exoPlayerContainer.exoPlayer?.seekTo(position)
    }

    override fun release() {
        exoPlayerContainer.exoPlayer?.release()
    }

    /**
     * Play media item
     * @param mediaItem
     * @param autoPlay
     */
    private fun play(mediaItem: MediaItem, autoPlay: Boolean) {
        if (playbackPosition != -1L) {
            exoPlayerContainer.exoPlayer?.seekTo(playbackPosition)
        }

        val haveResumePosition = resumeWindow != C.INDEX_UNSET
        if (haveResumePosition) {
            exoPlayerContainer.exoPlayer?.let { simplePlayer ->
                simplePlayer.seekTo(resumeWindow, resumePosition)

                val hlsMediaSource = mediaFactory.createHlsMediaSource(mediaItem)
                hlsMediaSource.addEventListener(
                    Handler(Looper.myLooper() ?: Looper.getMainLooper()),
                    mediaOnLoadCompletedListener
                )

                val ima = imaContainer.ima
                if (ima != null) {
                    val adsMediaSource = ima.createMediaSource(
                        mediaFactory.defaultMediaSourceFactory,
                        hlsMediaSource,
                        ImaCustomParams(
                            eventId = mediaData?.eventId,
                            streamId = mediaData?.streamId,
                            eventStatus = mediaData?.eventStatus
                        )
                    )
                    simplePlayer.setMediaSource(adsMediaSource, false)
                } else {
                    simplePlayer.setMediaSource(hlsMediaSource, false)
                }

                simplePlayer.prepare()
                simplePlayer.playWhenReady = autoPlay
                resumePosition = C.INDEX_UNSET.toLong()
                resumeWindow = C.INDEX_UNSET
            }
        } else {
            exoPlayerContainer.exoPlayer?.let { simplePlayer ->
                val hlsMediaSource = mediaFactory.createHlsMediaSource(mediaItem)
                hlsMediaSource.addEventListener(
                    Handler(Looper.myLooper() ?: Looper.getMainLooper()),
                    mediaOnLoadCompletedListener
                )

                val ima = imaContainer.ima
                if (ima != null) {
                    val adsMediaSource = ima.createMediaSource(
                        mediaFactory.defaultMediaSourceFactory,
                        hlsMediaSource,
                        ImaCustomParams(
                            eventId = mediaData?.eventId,
                            streamId = mediaData?.streamId,
                            eventStatus = mediaData?.eventStatus
                        )
                    )
                    simplePlayer.setMediaSource(adsMediaSource, true)
                } else {
                    simplePlayer.setMediaSource(hlsMediaSource, true)
                }

                simplePlayer.prepare()
                simplePlayer.playWhenReady = autoPlay
            }
        }
    }
}