package tv.mycujoo.mclsplayer.tv.presenter

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Color
import android.util.TypedValue
import android.view.KeyEvent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.leanback.widget.Action
import androidx.leanback.widget.ControlButtonPresenterSelector
import androidx.leanback.widget.OnActionClickedListener
import androidx.leanback.widget.PlaybackControlsRow
import androidx.leanback.widget.PlaybackControlsRow.OnPlaybackProgressCallback
import androidx.leanback.widget.PlaybackControlsRow.PlayPauseAction
import androidx.leanback.widget.PlaybackRowPresenter
import androidx.leanback.widget.PlaybackSeekDataProvider
import androidx.leanback.widget.PlaybackSeekUi
import androidx.leanback.widget.Presenter
import androidx.leanback.widget.RowPresenter
import tv.mycujoo.mclsplayer.tv.R
import tv.mycujoo.mclsplayer.tv.config.MCLSTVConfiguration
import tv.mycujoo.mclsplayer.tv.controller.ControllerAgent
import tv.mycujoo.mclsplayer.tv.controller.ILiveBadgeStateListener
import tv.mycujoo.mclsplayer.tv.widget.MLSPlaybackTransportRowView
import tv.mycujoo.mclsplayer.tv.widget.MLSSeekBar
import tv.mycujoo.mclsplayer.tv.widget.MLSThumbsBar
import tv.mycujoo.mclsplayercore.entity.LiveState
import java.util.Arrays

open class MLSPlaybackTransportRowPresenter(
    controllerAgent: ControllerAgent,
    config: MCLSTVConfiguration
) : PlaybackRowPresenter() {
    private val config: MCLSTVConfiguration
    private val controllerAgent: ControllerAgent

    class BoundData : MLSPlaybackControlPresenter.BoundData() {
        var mRowViewHolder: VH? = null
    }

    /**
     * A ViewHolder for the PlaybackControlsRow supporting seek UI.
     *
     * @param rootView             Root view of the ViewHolder.
     * @param descriptionPresenter The presenter that will be used to create description
     * ViewHolder. The description view will be added into tree.
     */
    inner class VH constructor(rootView: View, descriptionPresenter: Presenter?) :
        ViewHolder(rootView), PlaybackSeekUi {
        /**
         * @return The ViewHolder for description.
         */
        val descriptionViewHolder: Presenter.ViewHolder?

        // region Views
        val durationView: TextView?
        val mImageView: ImageView
        val mDescriptionDock: ViewGroup
        val mControlsDock: ViewGroup
        val mSecondaryControlsDock: ViewGroup
        val mTimersContainer: LinearLayout
        val currentPositionView: TextView
        val mSeekBarContainer: FrameLayout
        val mProgressBar: MLSSeekBar
        val mThumbsBar: MLSThumbsBar
        var mLiveBadgeLayout: FrameLayout
        val mViewersCountLayout: ConstraintLayout
        val mViewersCountTextView: TextView
        val mTimelineMarkerAnchor: View
        val mTimelineMarkerBackgroundLayout: FrameLayout
        val mTimelineMarkerTextView: TextView
        // endregion

        // region ViewHolders
        var mSelectedViewHolder: Presenter.ViewHolder? = null
        var mControlsVh: Presenter.ViewHolder? = null
        var mSecondaryControlsVh: Presenter.ViewHolder? = null
        // endregion

        var mTotalTimeInMs = Long.MIN_VALUE
        var mCurrentTimeInMs = Long.MIN_VALUE
        var mSecondaryProgressInMs: Long = 0
        val mTempBuilder = StringBuilder()

        var mControlsBoundData = BoundData()
        var mSecondaryBoundData = BoundData()

        var mSelectedItem: Any? = null
        var mPlayPauseAction: PlayPauseAction? = null
        var mThumbHeroIndex = -1
        var mSeekClient: PlaybackSeekUi.Client? = null
        var mInSeek = false
        var mSeekDataProvider: PlaybackSeekDataProvider? = null
        var mPositions: LongArray? = null
        var mPositionsLength = 0

        val mListener: OnPlaybackProgressCallback = object : OnPlaybackProgressCallback() {
            override fun onCurrentPositionChanged(row: PlaybackControlsRow, ms: Long) {
                setCurrentPosition(ms)
            }

            override fun onDurationChanged(row: PlaybackControlsRow, ms: Long) {
                setTotalTime(ms)
            }

            override fun onBufferedPositionChanged(row: PlaybackControlsRow, ms: Long) {
                setBufferedPosition(ms)
            }
        }

        init {
            // region Link Views
            mImageView = rootView.findViewById(R.id.image)
            mDescriptionDock = rootView.findViewById(R.id.description_dock)
            currentPositionView = rootView.findViewById(R.id.current_time)
            mTimersContainer = rootView.findViewById(R.id.tvController_timersContainer)
            durationView = rootView.findViewById(R.id.total_time)
            mSeekBarContainer = rootView.findViewById(R.id.tvController_seekBarContainer)
            mProgressBar = rootView.findViewById(R.id.playback_progress)
            mControlsDock = rootView.findViewById(R.id.controls_dock)
            mSecondaryControlsDock = rootView.findViewById(R.id.secondary_controls_dock)
            mThumbsBar = rootView.findViewById(R.id.thumbs_row)
            mLiveBadgeLayout = rootView.findViewById(R.id.tvController_liveBadgeLayout)
            mViewersCountLayout = rootView.findViewById(R.id.tvController_viewersCountLayout)
            mViewersCountTextView = rootView.findViewById(R.id.tvController_viewersCountTextView)
            mTimelineMarkerAnchor = rootView.findViewById(R.id.tvController_timelineMarkerAnchor)
            mTimelineMarkerBackgroundLayout =
                rootView.findViewById(R.id.tvController_timelineMarkerBackgroundLayout)
            mTimelineMarkerTextView =
                rootView.findViewById(R.id.tvController_timelineMarkerTextView)
            // endregion

            setupProgressBar()

            descriptionViewHolder = descriptionPresenter?.onCreateViewHolder(mDescriptionDock)
            if (descriptionViewHolder != null) {
                mDescriptionDock.addView(descriptionViewHolder.view)
            }

            mLiveBadgeLayout.setOnClickListener { v: View? ->
                controllerAgent.setControllerLiveMode(LiveState.LIVE_ON_THE_EDGE)
                controllerAgent.backToLive()
            }

            controllerAgent.setViewerCountView(mViewersCountLayout, mViewersCountTextView)

            val (primaryColor, _, _, _, _, _, showSeekBar, showTimers) = config.videoPlayerConfig
            progressColor = Color.parseColor(primaryColor)
            if (showSeekBar) {
                mSeekBarContainer.visibility = View.VISIBLE
            } else {
                mSeekBarContainer.visibility = View.GONE
            }
            if (showTimers) {
                mTimersContainer.visibility = View.VISIBLE
            } else {
                mTimersContainer.visibility = View.GONE
            }
        }

        private fun setupProgressBar() {
            mProgressBar.setOnClickListener { onProgressBarClicked(this@VH) }
            mProgressBar.setOnKeyListener { _: View?, keyCode: Int, keyEvent: KeyEvent ->
                when (keyCode) {
                    KeyEvent.KEYCODE_DPAD_UP, KeyEvent.KEYCODE_DPAD_DOWN ->                         // eat DPAD UP/DOWN in seek mode
                        return@setOnKeyListener mInSeek

                    KeyEvent.KEYCODE_DPAD_LEFT, KeyEvent.KEYCODE_MINUS, KeyEvent.KEYCODE_MEDIA_REWIND -> {
                        if (keyEvent.action == KeyEvent.ACTION_DOWN) {
                            onBackward()
                        }
                        return@setOnKeyListener true
                    }

                    KeyEvent.KEYCODE_DPAD_RIGHT, KeyEvent.KEYCODE_PLUS, KeyEvent.KEYCODE_MEDIA_FAST_FORWARD -> {
                        if (keyEvent.action == KeyEvent.ACTION_DOWN) {
                            onForward()
                        }
                        return@setOnKeyListener true
                    }

                    KeyEvent.KEYCODE_DPAD_CENTER, KeyEvent.KEYCODE_ENTER -> {
                        if (!mInSeek) {
                            return@setOnKeyListener false
                        }
                        if (keyEvent.action == KeyEvent.ACTION_UP) {
                            stopSeek(false)
                        }
                        return@setOnKeyListener true
                    }

                    KeyEvent.KEYCODE_BACK, KeyEvent.KEYCODE_ESCAPE -> {
                        if (!mInSeek) {
                            return@setOnKeyListener false
                        }
                        if (keyEvent.action == KeyEvent.ACTION_UP) {
                            // SeekBar does not support cancel in accessibility mode, so always
                            // "confirm" if accessibility is on.
                            stopSeek(!mProgressBar.isAccessibilityFocused)
                        }
                        return@setOnKeyListener true
                    }
                }
                false
            }
            mProgressBar.setAccessibilitySeekListener(object :
                MLSSeekBar.AccessibilitySeekListener() {
                override fun onAccessibilitySeekForward(): Boolean {
                    return onForward()
                }

                override fun onAccessibilitySeekBackward(): Boolean {
                    return onBackward()
                }
            })
            mProgressBar.max = Int.MAX_VALUE //current progress will be a fraction of this
        }

        fun updateProgressInSeek(forward: Boolean) {
            var newPos: Long
            val pos = mCurrentTimeInMs
            if (mPositionsLength > 0) {
                val index = Arrays.binarySearch(mPositions, 0, mPositionsLength, pos)
                val thumbHeroIndex: Int
                if (forward) {
                    if (index >= 0) {
                        // found it, seek to neighbour key position at higher side
                        if (index < mPositionsLength - 1) {
                            newPos = mPositions!![index + 1]
                            thumbHeroIndex = index + 1
                        } else {
                            newPos = mTotalTimeInMs
                            thumbHeroIndex = index
                        }
                    } else {
                        // not found, seek to neighbour key position at higher side.
                        val insertIndex = -1 - index
                        if (insertIndex <= mPositionsLength - 1) {
                            newPos = mPositions!![insertIndex]
                            thumbHeroIndex = insertIndex
                        } else {
                            newPos = mTotalTimeInMs
                            thumbHeroIndex = insertIndex - 1
                        }
                    }
                } else {
                    if (index >= 0) {
                        // found it, seek to neighbour key position at lower side.
                        if (index > 0) {
                            newPos = mPositions!![index - 1]
                            thumbHeroIndex = index - 1
                        } else {
                            newPos = 0
                            thumbHeroIndex = 0
                        }
                    } else {
                        // not found, seek to neighbour key position at lower side.
                        val insertIndex = -1 - index
                        if (insertIndex > 0) {
                            newPos = mPositions!![insertIndex - 1]
                            thumbHeroIndex = insertIndex - 1
                        } else {
                            newPos = 0
                            thumbHeroIndex = 0
                        }
                    }
                }
                updateThumbsInSeek(thumbHeroIndex, forward)
            } else {
                val interval: Long = (mTotalTimeInMs * defaultSeekIncrement).toLong()
                newPos = pos + if (forward) interval else -interval
                if (newPos > mTotalTimeInMs) {
                    newPos = mTotalTimeInMs
                } else if (newPos < 0) {
                    newPos = 0
                }
            }
            val ratio = newPos.toDouble() / mTotalTimeInMs // Range: [0, 1]
            mProgressBar.setProgress((ratio * Int.MAX_VALUE).toInt()) // Could safely cast to int
            mProgressBar.setCurrentTimeBySeek(newPos)
            mSeekClient!!.onSeekPositionChanged(newPos)
        }

        fun updateThumbsInSeek(thumbHeroIndex: Int, forward: Boolean) {
            var forward = forward
            if (mThumbHeroIndex == thumbHeroIndex) {
                return
            }
            val totalNum = mThumbsBar?.childCount ?: 0
            if (totalNum < 0 || totalNum and 1 == 0) {
                throw RuntimeException()
            }
            val heroChildIndex = totalNum / 2
            val start = (thumbHeroIndex - totalNum / 2).coerceAtLeast(0)
            val end = (thumbHeroIndex + totalNum / 2).coerceAtMost(mPositionsLength - 1)
            val newRequestStart: Int
            val newRequestEnd: Int
            if (mThumbHeroIndex < 0) {
                // first time
                newRequestStart = start
                newRequestEnd = end
            } else {
                forward = thumbHeroIndex > mThumbHeroIndex
                val oldStart = (mThumbHeroIndex - totalNum / 2).coerceAtLeast(0)
                val oldEnd = (mThumbHeroIndex + totalNum / 2).coerceAtMost(mPositionsLength - 1)
                if (forward) {
                    newRequestStart = (oldEnd + 1).coerceAtLeast(start)
                    newRequestEnd = end
                    // overlapping area directly assign bitmap from previous result
                    for (i in start until newRequestStart) {
                        mThumbsBar?.setThumbBitmap(
                            heroChildIndex + (i - thumbHeroIndex),
                            mThumbsBar?.getThumbBitmap(heroChildIndex + (i - mThumbHeroIndex))
                        )
                    }
                } else {
                    newRequestEnd = Math.min(oldStart - 1, end)
                    newRequestStart = start
                    // overlapping area directly assign bitmap from previous result in backward
                    for (i in end downTo newRequestEnd + 1) {
                        mThumbsBar?.setThumbBitmap(
                            heroChildIndex + (i - thumbHeroIndex),
                            mThumbsBar?.getThumbBitmap(heroChildIndex + (i - mThumbHeroIndex))
                        )
                    }
                }
            }
            // processing new requests with mThumbHeroIndex updated
            mThumbHeroIndex = thumbHeroIndex
            if (forward) {
                for (i in newRequestStart..newRequestEnd) {
                    mSeekDataProvider!!.getThumbnail(i, mThumbResult)
                }
            } else {
                for (i in newRequestEnd downTo newRequestStart) {
                    mSeekDataProvider!!.getThumbnail(i, mThumbResult)
                }
            }
            // set thumb bitmaps outside (start , end) to null
            for (childIndex in 0 until heroChildIndex - mThumbHeroIndex + start) {
                mThumbsBar?.setThumbBitmap(childIndex, null)
            }
            for (childIndex in heroChildIndex + end - mThumbHeroIndex + 1 until totalNum) {
                mThumbsBar?.setThumbBitmap(childIndex, null)
            }
        }

        var mThumbResult: PlaybackSeekDataProvider.ResultCallback =
            object : PlaybackSeekDataProvider.ResultCallback() {
                override fun onThumbnailLoaded(bitmap: Bitmap, index: Int) {
                    val count = mThumbsBar?.childCount ?: 0
                    val childIndex = index - (mThumbHeroIndex - count / 2)
                    if (childIndex < 0 || childIndex >= count) {
                        return
                    }
                    mThumbsBar?.setThumbBitmap(childIndex, bitmap)
                }
            }

        fun onForward(): Boolean {
            if (!startSeek()) {
                return false
            }
            updateProgressInSeek(true)
            return true
        }

        fun onBackward(): Boolean {
            if (!startSeek()) {
                return false
            }
            updateProgressInSeek(false)
            return true
        }

        override fun setPlaybackSeekUiClient(client: PlaybackSeekUi.Client) {
            mSeekClient = client
        }

        fun startSeek(): Boolean {
            if (mInSeek) {
                return true
            }
            if (mSeekClient == null || !mSeekClient!!.isSeekEnabled || mTotalTimeInMs <= 0) {
                return false
            }
            mInSeek = true
            mSeekClient!!.onSeekStarted()
            mSeekDataProvider = mSeekClient!!.playbackSeekDataProvider
            mPositions = if (mSeekDataProvider != null) mSeekDataProvider!!.seekPositions else null
            mPositionsLength = if (mPositions != null) {
                val pos = Arrays.binarySearch(mPositions, mTotalTimeInMs)
                if (pos >= 0) {
                    pos + 1
                } else {
                    -1 - pos
                }
            } else {
                0
            }
            mControlsVh!!.view.visibility = View.GONE
            mSecondaryControlsVh!!.view.visibility = View.INVISIBLE
            descriptionViewHolder!!.view.visibility = View.INVISIBLE
            mThumbsBar?.visibility = View.VISIBLE
            return true
        }

        fun stopSeek(cancelled: Boolean) {
            if (!mInSeek) {
                return
            }
            mInSeek = false
            mSeekClient!!.onSeekFinished(cancelled)
            if (mSeekDataProvider != null) {
                mSeekDataProvider!!.reset()
            }
            mThumbHeroIndex = -1
            mThumbsBar?.clearThumbBitmaps()
            mSeekDataProvider = null
            mPositions = null
            mPositionsLength = 0
            mControlsVh!!.view.visibility = View.VISIBLE
            mSecondaryControlsVh!!.view.visibility = View.VISIBLE
            descriptionViewHolder!!.view.visibility = View.VISIBLE
            mThumbsBar?.visibility = View.INVISIBLE
        }

        fun dispatchItemSelection() {
            if (!isSelected) {
                return
            }
            if (mSelectedViewHolder == null) {
                if (onItemViewSelectedListener != null) {
                    onItemViewSelectedListener.onItemSelected(
                        null, null,
                        this@VH, row
                    )
                }
            } else {
                if (onItemViewSelectedListener != null) {
                    onItemViewSelectedListener.onItemSelected(
                        mSelectedViewHolder,
                        mSelectedItem, this@VH, row
                    )
                }
            }
        }

        fun getPresenter(primary: Boolean): Presenter? {
            val adapter =
                (if (primary) (row as PlaybackControlsRow).primaryActionsAdapter else (row as PlaybackControlsRow).secondaryActionsAdapter)
                    ?: return null
            if (adapter.presenterSelector is ControlButtonPresenterSelector) {
                val selector = adapter.presenterSelector as ControlButtonPresenterSelector
                return selector.secondaryPresenter
            }
            return adapter.getPresenter(if (adapter.size() > 0) adapter[0] else null)
        }

        /**
         * Called to update total time label. Default implementation updates the TextView
         * [.getDurationView]. Subclass might override.
         *
         * @param totalTimeMs Total duration of the media in milliseconds.
         */
        protected fun onSetDurationLabel(totalTimeMs: Long) {
            if (durationView != null) {
                formatTime(totalTimeMs, mTempBuilder)
                durationView.text = mTempBuilder.toString()
            }
        }

        fun setTotalTime(totalTimeMs: Long) {
            if (mTotalTimeInMs != totalTimeMs) {
                mTotalTimeInMs = totalTimeMs
                onSetDurationLabel(totalTimeMs)
                mProgressBar.setTotalTime(totalTimeMs)
            }
        }

        /**
         * Called to update current time label. Default implementation updates the TextView
         * [.getCurrentPositionView]. Subclass might override.
         *
         * @param currentTimeMs Current playback position in milliseconds.
         */
        protected fun onSetCurrentPositionLabel(currentTimeMs: Long) {
            if (currentPositionView != null) {
                formatTime(currentTimeMs, mTempBuilder)
                currentPositionView.text = mTempBuilder.toString()
            }
        }

        fun setCurrentPosition(currentTimeMs: Long) {
            if (currentTimeMs != mCurrentTimeInMs) {
                mCurrentTimeInMs = currentTimeMs
                onSetCurrentPositionLabel(currentTimeMs)
            }
            if (!mInSeek) {
                var progressRatio = 0
                if (mTotalTimeInMs > 0) {
                    // Use ratio to represent current progres
                    val ratio = mCurrentTimeInMs.toDouble() / mTotalTimeInMs // Range: [0, 1]
                    progressRatio = (ratio * Int.MAX_VALUE).toInt() // Could safely cast to int
                }
                mProgressBar.setProgress(progressRatio)
            }
        }

        fun setBufferedPosition(progressMs: Long) {
            mSecondaryProgressInMs = progressMs
            // Solve the progress bar by using ratio
            val ratio = progressMs.toDouble() / mTotalTimeInMs // Range: [0, 1]
            val progressRatio = ratio * Int.MAX_VALUE // Could safely cast to int
            mProgressBar.setSecondaryProgress(progressRatio.toInt())
        }
    }
    /**
     * Get default seek increment if [PlaybackSeekDataProvider] is null.
     *
     * @return float value between 0(inclusive) and 1(inclusive).
     */
    /**
     * Set default seek increment if [PlaybackSeekDataProvider] is null.
     *
     * @param ratio float value between 0(inclusive) and 1(inclusive).
     */
    var defaultSeekIncrement = 0.01f
    var mProgressColor = Color.TRANSPARENT
    var mSecondaryProgressColor = Color.TRANSPARENT
    var mProgressColorSet = false
    var mSecondaryProgressColorSet = false
    var mDescriptionPresenter: Presenter? = null
    var mPlaybackControlsPresenter: MLSControlBarPresenter
    var mSecondaryControlsPresenter: MLSControlBarPresenter
    /**
     * Returns the listener for [Action] click events.
     */
    /**
     * Sets the listener for [Action] click events.
     */
    var onActionClickedListener: OnActionClickedListener? = null
    private val mOnControlSelectedListener = object :
        MLSControlBarPresenter.OnControlSelectedListener {

        override fun onControlSelected(
            controlViewHolder: Presenter.ViewHolder?,
            item: Any?,
            data: MLSControlBarPresenter.BoundData?
        ) {
            val vh = (data as BoundData).mRowViewHolder
            if (vh!!.mSelectedViewHolder !== controlViewHolder || vh!!.mSelectedItem !== item) {
                vh!!.mSelectedViewHolder = controlViewHolder
                vh.mSelectedItem = item
                vh.dispatchItemSelection()
            }
        }
    }

    private val mOnControlClickedListener: MLSControlBarPresenter.OnControlClickedListener =
        object : MLSControlBarPresenter.OnControlClickedListener {
            override fun onControlClicked(
                controlViewHolder: Presenter.ViewHolder?, item: Any?,
                data: MLSControlBarPresenter.BoundData?
            ) {
                val vh = (data as BoundData?)!!.mRowViewHolder
                if (vh!!.onItemViewClickedListener != null) {
                    vh.onItemViewClickedListener.onItemClicked(
                        controlViewHolder, item,
                        vh, vh.row
                    )
                }
                if (onActionClickedListener != null && item is Action) {
                    onActionClickedListener!!.onActionClicked(item as Action?)
                }
            }
        }

    init {
        headerPresenter = null
        selectEffectEnabled = false
        this.config = config
        this.controllerAgent = controllerAgent
        mPlaybackControlsPresenter = MLSControlBarPresenter(R.layout.layout_mls_control_bar)
        mPlaybackControlsPresenter.defaultFocusToMiddle = false
        mSecondaryControlsPresenter = MLSControlBarPresenter(R.layout.layout_mls_control_bar)
        mSecondaryControlsPresenter.defaultFocusToMiddle = false
        mPlaybackControlsPresenter.onControlSelectedListener = mOnControlSelectedListener
        mSecondaryControlsPresenter.onControlSelectedListener = mOnControlSelectedListener
        mPlaybackControlsPresenter.onControlClickedListener = mOnControlClickedListener
        mSecondaryControlsPresenter.onControlClickedListener = mOnControlClickedListener
    }

    /**
     * @param descriptionPresenter Presenter for displaying item details.
     */
    fun setDescriptionPresenter(descriptionPresenter: Presenter?) {
        mDescriptionPresenter = descriptionPresenter
    }
    /**
     * Returns the primary color for the progress bar.  If no color was set, transparent
     * is returned.
     */
    /**
     * Sets the primary color for the progress bar.  If not set, a default from
     * the theme will be used.
     */
    @get:ColorInt
    var progressColor: Int
        get() = mProgressColor
        set(color) {
            mProgressColor = color
            mProgressColorSet = true
        }
    /**
     * Returns the secondary color for the progress bar.  If no color was set, transparent
     * is returned.
     */
    /**
     * Sets the secondary color for the progress bar.  If not set, a default from
     * the theme [androidx.leanback.R.attr.playbackProgressSecondaryColor] will be used.
     *
     * @param color Color used to draw secondary progress.
     */
    @get:ColorInt
    var secondaryProgressColor: Int
        get() = mSecondaryProgressColor
        set(color) {
            mSecondaryProgressColor = color
            mSecondaryProgressColorSet = true
        }

    override fun onReappear(rowViewHolder: RowPresenter.ViewHolder) {
        val vh = rowViewHolder as VH
        if (vh.view.hasFocus()) {
            vh.mProgressBar.requestFocus()
        }
    }

    override fun createRowViewHolder(parent: ViewGroup): RowPresenter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(
            R.layout.layout_mls_playback_transport_controls_row,
            parent,
            false
        )
        val vh = VH(v, mDescriptionPresenter)
        initRow(vh)
        return vh
    }

    private fun initRow(vh: VH) {
        vh.mControlsVh = mPlaybackControlsPresenter
            .onCreateViewHolder(vh.mControlsDock)
        vh.mProgressBar.setProgressColor(
            if (mProgressColorSet) mProgressColor else getDefaultProgressColor(
                vh.mControlsDock.context
            )
        )
        vh.mProgressBar.secondaryProgressColor =
            if (mSecondaryProgressColorSet) mSecondaryProgressColor else getDefaultSecondaryProgressColor(
                vh.mControlsDock.context
            )
        vh.mControlsDock.addView(vh.mControlsVh!!.view)
        vh.mSecondaryControlsVh = mSecondaryControlsPresenter
            .onCreateViewHolder(vh.mSecondaryControlsDock)
        vh.mSecondaryControlsDock.addView(vh.mSecondaryControlsVh!!.view)
        (vh.view.findViewById<View>(R.id.transport_row) as MLSPlaybackTransportRowView)
            .onUnhandledKeyListener = object : MLSPlaybackTransportRowView.OnUnhandledKeyListener {
            override fun onUnhandledKey(event: KeyEvent?): Boolean {
                return if (vh.onKeyListener != null && event != null) {
                    return vh.onKeyListener.onKey(
                        vh.view,
                        event.keyCode,
                        event
                    )
                } else false
            }
        }
    }

    override fun onBindRowViewHolder(holder: RowPresenter.ViewHolder, item: Any) {
        super.onBindRowViewHolder(holder, item)
        val vh = holder as VH
        val row = vh.row as PlaybackControlsRow
        if (row.item == null) {
            vh.mDescriptionDock.visibility = View.GONE
        } else {
            vh.mDescriptionDock.visibility = View.VISIBLE
            if (vh.descriptionViewHolder != null) {
                mDescriptionPresenter!!.onBindViewHolder(vh.descriptionViewHolder, row.item)
            }
        }
        if (row.imageDrawable == null) {
            vh.mImageView.visibility = View.GONE
        } else {
            vh.mImageView.visibility = View.VISIBLE
        }
        vh.mImageView.setImageDrawable(row.imageDrawable)
        vh.mControlsBoundData.adapter = row.primaryActionsAdapter
        vh.mControlsBoundData.presenter = vh.getPresenter(true)
        vh.mControlsBoundData.mRowViewHolder = vh
        mPlaybackControlsPresenter.onBindViewHolder(vh.mControlsVh, vh.mControlsBoundData)
        vh.mSecondaryBoundData.adapter = row.secondaryActionsAdapter
        vh.mSecondaryBoundData.presenter = vh.getPresenter(false)
        vh.mSecondaryBoundData.mRowViewHolder = vh
        mSecondaryControlsPresenter.onBindViewHolder(
            vh.mSecondaryControlsVh,
            vh.mSecondaryBoundData
        )
        vh.setTotalTime(row.duration)
        vh.setCurrentPosition(row.currentPosition)
        vh.setBufferedPosition(row.bufferedPosition)
        row.setOnPlaybackProgressChangedListener(vh.mListener)
        controllerAgent.addLiveBadgeStateListener(object : ILiveBadgeStateListener {
            override fun setState(state: LiveState) {
                setIsLive(
                    state,
                    vh.mLiveBadgeLayout
                )
            }

        })
    }

    override fun onUnbindRowViewHolder(holder: RowPresenter.ViewHolder) {
        val vh = holder as VH
        val row = vh.row as PlaybackControlsRow
        if (vh.descriptionViewHolder != null) {
            mDescriptionPresenter!!.onUnbindViewHolder(vh.descriptionViewHolder)
        }
        mPlaybackControlsPresenter.onUnbindViewHolder(vh.mControlsVh)
        mSecondaryControlsPresenter.onUnbindViewHolder(vh.mSecondaryControlsVh)
        row.setOnPlaybackProgressChangedListener(null)
        super.onUnbindRowViewHolder(holder)
    }

    /**
     * Client of progress bar is clicked, default implementation delegate click to
     * PlayPauseAction.
     *
     * @param vh ViewHolder of PlaybackTransportRowPresenter
     */
    protected fun onProgressBarClicked(vh: VH?) {
        if (vh != null) {
            if (vh.mPlayPauseAction == null) {
                vh.mPlayPauseAction = PlayPauseAction(vh.view.context)
            }
            if (vh.onItemViewClickedListener != null) {
                vh.onItemViewClickedListener.onItemClicked(
                    vh, vh.mPlayPauseAction,
                    vh, vh.row
                )
            }
            if (onActionClickedListener != null) {
                onActionClickedListener!!.onActionClicked(vh.mPlayPauseAction)
            }
        }
    }

    override fun onRowViewSelected(vh: RowPresenter.ViewHolder, selected: Boolean) {
        super.onRowViewSelected(vh, selected)
        if (selected) {
            (vh as VH).dispatchItemSelection()
        }
    }

    override fun onRowViewAttachedToWindow(vh: RowPresenter.ViewHolder) {
        super.onRowViewAttachedToWindow(vh)
        if (mDescriptionPresenter != null) {
            mDescriptionPresenter!!.onViewAttachedToWindow(
                (vh as VH).descriptionViewHolder
            )
        }
    }

    override fun onRowViewDetachedFromWindow(vh: RowPresenter.ViewHolder) {
        super.onRowViewDetachedFromWindow(vh)
        if (mDescriptionPresenter != null) {
            mDescriptionPresenter!!.onViewDetachedFromWindow(
                (vh as VH).descriptionViewHolder
            )
        }
    }

    private fun setIsLive(state: LiveState, liveBadgeLayout: FrameLayout) {
        when (state) {
            LiveState.LIVE_ON_THE_EDGE -> {
                liveBadgeLayout.isFocusable = false
                liveBadgeLayout.visibility = View.VISIBLE
                liveBadgeLayout.background = ContextCompat.getDrawable(
                    liveBadgeLayout.context,
                    tv.mycujoo.mclsplayercore.R.drawable.bg_live
                )
            }

            LiveState.LIVE_TRAILING -> {
                liveBadgeLayout.isFocusable = true
                liveBadgeLayout.visibility = View.VISIBLE
                liveBadgeLayout.background = ContextCompat.getDrawable(
                    liveBadgeLayout.context,
                    R.drawable.selector_live_badge_button
                )
            }

            LiveState.VOD -> liveBadgeLayout.visibility = View.GONE
        }
    }

    companion object {
        fun formatTime(ms: Long, sb: StringBuilder) {
            sb.setLength(0)
            if (ms < 0) {
                sb.append("--")
                return
            }
            var seconds = ms / 1000
            var minutes = seconds / 60
            val hours = minutes / 60
            seconds -= minutes * 60
            minutes -= hours * 60
            if (hours > 0) {
                sb.append(hours).append(':')
                if (minutes < 10) {
                    sb.append('0')
                }
            }
            sb.append(minutes).append(':')
            if (seconds < 10) {
                sb.append('0')
            }
            sb.append(seconds)
        }

        private fun getDefaultProgressColor(context: Context): Int {
            val outValue = TypedValue()
            return if (context.theme.resolveAttribute(
                    androidx.leanback.R.attr.playbackProgressPrimaryColor,
                    outValue,
                    true
                )
            ) {
                context.resources.getColor(outValue.resourceId)
            } else context.resources.getColor(androidx.leanback.R.color.lb_playback_progress_color_no_theme)
        }

        private fun getDefaultSecondaryProgressColor(context: Context): Int {
            val outValue = TypedValue()
            return if (context.theme.resolveAttribute(
                    androidx.leanback.R.attr.playbackProgressSecondaryColor,
                    outValue,
                    true
                )
            ) {
                context.resources.getColor(outValue.resourceId)
            } else context.resources.getColor(
                androidx.leanback.R.color.lb_playback_progress_secondary_color_no_theme
            )
        }
    }
}