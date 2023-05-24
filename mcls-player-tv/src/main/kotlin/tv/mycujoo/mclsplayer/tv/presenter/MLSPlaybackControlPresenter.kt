package tv.mycujoo.mclsplayer.tv.presenter

import android.content.Context
import android.graphics.drawable.ClipDrawable
import android.graphics.drawable.ColorDrawable
import android.graphics.drawable.LayerDrawable
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewGroup.MarginLayoutParams
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import androidx.core.view.isVisible
import androidx.leanback.widget.ObjectAdapter
import androidx.leanback.widget.ObjectAdapter.DataObserver
import androidx.leanback.widget.PlaybackControlsRow
import androidx.leanback.widget.Presenter
import tv.mycujoo.mclsplayer.tv.R
import tv.mycujoo.mclsplayercore.utils.MathUtils

/**
 * Constructor for a PlaybackControlsRowPresenter.
 *
 * @param layoutResourceId The resource id of the layout for this presenter.
 */
class MLSPlaybackControlPresenter(
    @LayoutRes layoutResourceId: Int
) : MLSControlBarPresenter(layoutResourceId) {

    var mMoreActionsEnabled = true

    init {

    }


    open class BoundData : MLSControlBarPresenter.BoundData() {
        /**
         * The data type expected by this presenter.
         * The adapter containing secondary actions.
         */
        var secondaryActionsAdapter: ObjectAdapter? = null
    }

    inner class MLSPlaybackControlPresenterViewHolder(
        rootView: View
    ) : MCLSControlBarViewHolder(rootView) {

        var mMoreActionsAdapter: ObjectAdapter? = null
        var mMoreActionsObserver: DataObserver? = null
        var mMoreActionsDock: FrameLayout? = null
        var mMoreActionsViewHolder: ViewHolder? = null
        var mMoreActionsShowing = false
        var mCurrentTime: TextView? = null
        var mTotalTime: TextView? = null
        var mProgressBar: ProgressBar? = null
        var mCurrentTimeInMs: Long = -1 // Hold current time in milliseconds

        var mTotalTimeInMs: Long = -1 // Hold total time in milliseconds

        var mSecondaryProgressInMs: Long = -1 // Hold secondary progress in milliseconds

        var mTotalTimeStringBuilder = StringBuilder()
        var mCurrentTimeStringBuilder = StringBuilder()
        var mCurrentTimeMarginStart = 0
        var mTotalTimeMarginEnd = 0

        init {
            mMoreActionsDock = rootView.findViewById(androidx.leanback.R.id.more_actions_dock)
            mCurrentTime = rootView.findViewById(R.id.current_time)
            mTotalTime = rootView.findViewById(R.id.total_time)
            mProgressBar = rootView.findViewById(R.id.playback_progress)

            mMoreActionsObserver = object : DataObserver() {
                override fun onChanged() {
                    if (mMoreActionsShowing) {
                        showControls(presenter)
                    }
                }

                override fun onItemRangeChanged(positionStart: Int, itemCount: Int) {
                    if (mMoreActionsShowing) {
                        presenter?.let {
                            for (i in 0 until itemCount) {
                                bindControlToAction(positionStart + i, it)
                            }
                        }
                    }
                }
            }
            mCurrentTime?.let {
                mCurrentTimeMarginStart =
                    (it.layoutParams as ViewGroup.MarginLayoutParams).marginStart
                mTotalTimeMarginEnd = (it.layoutParams as ViewGroup.MarginLayoutParams).marginEnd
            }
        }

        fun showMoreActions(show: Boolean) {
            if (show) {
                if (mMoreActionsViewHolder == null) {
                    mMoreActionsDock?.let { mMoreActionsDock ->
                        val action = PlaybackControlsRow.MoreActions(mMoreActionsDock.context)
                        mMoreActionsViewHolder = presenter?.onCreateViewHolder(mMoreActionsDock)
                        presenter?.onBindViewHolder(mMoreActionsViewHolder, action)
                        presenter?.setOnClickListener(mMoreActionsViewHolder) {
                            toggleMoreActions()
                        }
                    }
                }

                mMoreActionsViewHolder?.view?.let {
                    if (view.parent == null) {
                        mMoreActionsDock?.addView(it)
                    }
                }
            } else if (mMoreActionsViewHolder != null &&
                mMoreActionsViewHolder?.view?.parent != null
            ) {
                mMoreActionsDock?.removeView(mMoreActionsViewHolder?.view)
            }
        }

        fun toggleMoreActions() {
            mMoreActionsShowing = !mMoreActionsShowing
            showControls(presenter)
        }

        override fun getDisplayedAdapter(): ObjectAdapter? {
            return if (mMoreActionsShowing) {
                mMoreActionsAdapter
            } else {
                adapter
            }
        }

        override fun getChildMarginFromCenter(context: Context, numControls: Int): Int {
            var margin = getControlIconWidth(context)
            margin += if (numControls < 4) {
                getChildMarginBiggest(context)
            } else if (numControls < 6) {
                getChildMarginBigger(context)
            } else {
                getChildMarginDefault(context)
            }
            return margin
        }

        private fun getChildMarginBigger(context: Context): Int {
            if (sChildMarginBigger == 0) {
                sChildMarginBigger = context.resources.getDimensionPixelSize(
                    androidx.leanback.R.dimen.lb_playback_controls_child_margin_bigger
                )
            }
            return sChildMarginBigger
        }

        private fun getChildMarginBiggest(context: Context): Int {
            if (sChildMarginBiggest == 0) {
                sChildMarginBiggest = context.resources.getDimensionPixelSize(
                    androidx.leanback.R.dimen.lb_playback_controls_child_margin_biggest
                )
            }
            return sChildMarginBiggest
        }

        fun setTotalTime(totalTimeMs: Long) {
            if (totalTimeMs >= 0) {
                mTotalTime?.isVisible = false
                mProgressBar?.isVisible = false
            } else {
                mTotalTime?.isVisible = true
                mProgressBar?.isVisible = true
                mTotalTimeInMs = totalTimeMs
                formatTime(totalTimeMs / 1000, mTotalTimeStringBuilder)
                mTotalTime?.text = mTotalTimeStringBuilder.toString()
                mProgressBar?.max = Int.MAX_VALUE
            }
        }

        fun getTotalTime(): Long = mTotalTimeInMs

        fun setCurrentTime(currentTimeMs: Long) {
            val seconds = currentTimeMs / 1000
            if (currentTimeMs != mCurrentTimeInMs) {
                mCurrentTimeInMs = currentTimeMs
                formatTime(seconds, mCurrentTimeStringBuilder)
                mCurrentTime?.text = mCurrentTimeStringBuilder.toString()
            }

            // Use ration to represent current progress
            val ratio = mCurrentTimeInMs.toDouble() / mTotalTimeInMs.toDouble()
            val progressRation = ratio * Int.MAX_VALUE
            mProgressBar?.progress = progressRation.toInt()
        }

        fun getCurrentTime() = mTotalTimeInMs

        fun setSecondaryProgress(progressMs: Long) {
            mSecondaryProgressInMs = progressMs
            val ratio = progressMs.toDouble() / mTotalTimeInMs.toDouble()
            val progressRatio = ratio * Int.MAX_VALUE
            mProgressBar?.secondaryProgress = progressRatio.toInt()
        }

        fun getSecondaryProgress() = mSecondaryProgressInMs
    }

    /**
     * Enables the display of secondary actions.
     * A "more actions" button will be displayed.  When "more actions" is selected,
     * the primary actions are replaced with the secondary actions.
     */
    fun enableSecondaryActions(enabled: Boolean) {
        mMoreActionsEnabled = enabled
    }

    /**
     * Returns true if secondary actions are enabled.
     */
    fun areMoreActionsEnabled() = mMoreActionsEnabled

    fun setProgressColor(vh: MLSPlaybackControlPresenterViewHolder, @ColorInt color: Int) {
        val drawable = ClipDrawable(ColorDrawable(color), Gravity.START, ClipDrawable.HORIZONTAL)
        (vh.mProgressBar?.progressDrawable as LayerDrawable?)?.setDrawableByLayerId(
            android.R.id.progress,
            drawable
        )
    }

    fun setTotalTime(
        vh: MLSPlaybackControlPresenter.MLSPlaybackControlPresenterViewHolder,
        ms: Long
    ) {
        vh.setTotalTime(ms)
    }

    fun getTotalTime(vh: MLSPlaybackControlPresenterViewHolder): Int {
        return MathUtils.safeLongToInt(getTotalTimeLong(vh))
    }

    fun getTotalTimeLong(vh: MLSPlaybackControlPresenterViewHolder): Long {
        return vh.getTotalTime()
    }

    fun setCurrentTime(vh: MLSPlaybackControlPresenterViewHolder, ms: Int) {
        setCurrentTimeLong(vh, ms.toLong())
    }

    fun setCurrentTimeLong(vh: MLSPlaybackControlPresenterViewHolder, ms: Long) {
        vh.setCurrentTime(ms)
    }

    fun getCurrentTime(vh: MLSPlaybackControlPresenterViewHolder): Int {
        return MathUtils.safeLongToInt(getCurrentTimeLong(vh))
    }

    fun getCurrentTimeLong(vh: MLSPlaybackControlPresenterViewHolder): Long {
        return vh.getCurrentTime()
    }

    fun setSecondaryProgress(vh: MLSPlaybackControlPresenterViewHolder, progressMs: Int) {
        setSecondaryProgressLong(vh, progressMs.toLong())
    }

    fun setSecondaryProgressLong(vh: MLSPlaybackControlPresenterViewHolder, progressMs: Long) {
        vh.setSecondaryProgress(progressMs)
    }

    fun showPrimaryActions(vh: MLSPlaybackControlPresenterViewHolder) {
        if (vh.mMoreActionsShowing) {
            vh.toggleMoreActions()
        }
    }

    fun resetFocus(vh: MLSPlaybackControlPresenterViewHolder) {
        vh.controlBar.requestFocus()
    }

    fun enableTimeMargins(vh: MLSPlaybackControlPresenterViewHolder, enable: Boolean) {
        var lp = vh.mCurrentTime?.layoutParams as MarginLayoutParams?
        lp?.marginStart = if (enable) vh.mCurrentTimeMarginStart else 0
        vh.mCurrentTime?.layoutParams = lp

        lp = vh.mTotalTime?.layoutParams as MarginLayoutParams?
        lp?.marginEnd = if (enable) vh.mTotalTimeMarginEnd else 0
        vh.mTotalTime?.layoutParams = lp
    }

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        if (parent == null) {
            throw IllegalArgumentException("ViewHolder Parent is null, so a ViewHolder can't be inflated")
        }
        val v = LayoutInflater.from(parent.context)
            .inflate(layoutResId, parent, false)
        return MCLSControlBarViewHolder(v)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
        if (viewHolder == null) {
            return
        }

        if (item == null) {
            return
        }

        val vh = viewHolder as MLSPlaybackControlPresenterViewHolder
        val data = item as BoundData

        // If binding to a new adapter, display primary actions.

        // If binding to a new adapter, display primary actions.
        if (vh.mMoreActionsAdapter !== data.secondaryActionsAdapter) {
            vh.mMoreActionsAdapter = data.secondaryActionsAdapter
            vh.mMoreActionsAdapter?.registerObserver(vh.mMoreActionsObserver)
            vh.mMoreActionsShowing = false
        }

        super.onBindViewHolder(viewHolder, item)
        vh.showMoreActions(mMoreActionsEnabled)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
        super.onUnbindViewHolder(viewHolder)

        if (viewHolder == null) {
            return
        }

        val vh = viewHolder as MLSPlaybackControlPresenterViewHolder
        vh.mMoreActionsAdapter?.unregisterObserver(vh.mMoreActionsObserver)
        vh.mMoreActionsAdapter = null
    }



    companion object {
        var sChildMarginBigger = 0
        var sChildMarginBiggest = 0

        fun formatTime(seconds: Long, sb: StringBuilder) {
            var seconds = seconds
            var minutes = seconds / 60
            val hours = minutes / 60
            seconds -= minutes * 60
            minutes -= hours * 60
            sb.setLength(0)
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
    }
}