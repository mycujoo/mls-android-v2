package tv.mycujoo.mclsplayer.tv.presenter

import android.content.Context
import android.util.SparseArray
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.ColorInt
import androidx.annotation.LayoutRes
import androidx.leanback.widget.ObjectAdapter
import androidx.leanback.widget.Presenter
import tv.mycujoo.mclsplayer.tv.R
import tv.mycujoo.mclsplayer.tv.widget.MLSControlBar

open class MLSControlBarPresenter constructor(
    @LayoutRes val layoutResId: Int
) : Presenter() {

    companion object {
        const val MAX_CONTROLS = 7
        private var sControlIconWidth = 0
        private var sChildMarginDefault = 0
    }


    open class BoundData {
        /**
         * Adapter containing objects of type [Action].
         */
        var adapter: ObjectAdapter? = null

        /**
         * The presenter to be used for the adapter objects.
         */
        var presenter: Presenter? = null
    }

    /**
     * Listener for control selected events.
     */
    interface OnControlSelectedListener {
        fun onControlSelected(
            controlViewHolder: ViewHolder?,
            item: Any?,
            data: BoundData?,
        )
    }

    /**
     * Listener for control clicked events.
     */
    interface OnControlClickedListener {
        fun onControlClicked(
            controlViewHolder: ViewHolder?,
            item: Any?,
            data: BoundData?
        )
    }

    open inner class MCLSControlBarViewHolder constructor(
        rootView: View
    ) : ViewHolder(rootView) {
        val dataObserver: ObjectAdapter.DataObserver
        var adapter: ObjectAdapter? = null
        var presenter: Presenter? = null
        var data: BoundData? = null
        val controlBar: MLSControlBar
        private val mViewHolders = SparseArray<ViewHolder>()


        init {
            controlBar = rootView.findViewById(R.id.control_bar)
                ?: throw IllegalStateException("Couldn't find control_bar")
            controlBar.setDefaultFocusToMiddle(defaultFocusToMiddle)

            controlBar.setOnChildFocusedListener(object : MLSControlBar.OnChildFocusedListener {
                override fun onChildFocusedListener(child: View?, focused: View?) {
                    val mOnControlSelectedListener = onControlSelectedListener ?: return
                    for (position in 0 until mViewHolders.size()) {
                        if (mViewHolders.get(position).view == child) {
                            mOnControlSelectedListener.onControlSelected(
                                mViewHolders.get(position),
                                getDisplayedAdapter()?.get(position),
                                data
                            )
                            break
                        }
                    }
                }
            })

            dataObserver = object : ObjectAdapter.DataObserver() {
                override fun onChanged() {
                    if (adapter == getDisplayedAdapter()) {
                        showControls(presenter)
                    }
                }
            }
        }

        fun getControlIconWidth(context: Context): Int {
            if (sControlIconWidth == 0) {
                sControlIconWidth = context.resources.getDimensionPixelSize(
                    androidx.leanback.R.dimen.lb_control_icon_width
                )
            }

            return sControlIconWidth
        }

        fun getChildMarginDefault(context: Context): Int {
            if (sChildMarginDefault == 0) {
                sChildMarginDefault = context.resources.getDimensionPixelSize(
                    androidx.leanback.R.dimen.lb_playback_controls_child_margin_default
                )
            }

            return sChildMarginDefault
        }

        open fun getChildMarginFromCenter(context: Context, numControls: Int): Int {
            // Includes margin between icons plus two times half the icon width.
            return getChildMarginDefault(context) + getControlIconWidth(context)
        }

        fun showControls(presenter: Presenter?) {
            val adapter = getDisplayedAdapter() ?: return

            val adapterSize = adapter.size()
            // Shrink the number of attached views
            val focusedView = controlBar.focusedChild
            if (focusedView != null && adapterSize > 0 && controlBar.indexOfChild(focusedView) >= adapterSize) {
                controlBar.getChildAt(adapter.size() - 1).requestFocus()
            }
            for (i in controlBar.childCount - 1 downTo adapterSize) {
                controlBar.removeViewAt(i)
            }
            var position = 0
            while (position < adapterSize && position < MAX_CONTROLS) {
                presenter?.let {
                    bindControlToAction(position, adapter, presenter)
                }
                position++
            }
            controlBar.setChildMarginFromCenter(
                getChildMarginFromCenter(controlBar.context, adapterSize)
            )
        }

        fun bindControlToAction(position: Int, presenter: Presenter) {
            getDisplayedAdapter()?.let {
                bindControlToAction(position, it, presenter)
            }
        }

        private fun bindControlToAction(
            position: Int,
            adapter: ObjectAdapter,
            presenter: Presenter
        ) {
            var vh = mViewHolders.get(position)
            val item = adapter.get(position)

            if (vh == null) {
                vh = presenter.onCreateViewHolder(controlBar);
                mViewHolders.put(position, vh)

                val itemViewHolder = vh
                presenter.setOnClickListener(vh) {
                    val currentItem = getDisplayedAdapter()?.get(position)
                    onControlClickedListener?.onControlClicked(
                        itemViewHolder,
                        currentItem,
                        data
                    )
                }
            }

            if (vh.view.parent == null) {
                controlBar.addView(vh.view)
            }

            presenter.onBindViewHolder(vh, item)
        }

        /**
         * Returns the adapter currently bound to the displayed controls.
         * May be overridden in a subclass.
         */
        open fun getDisplayedAdapter(): ObjectAdapter? {
            return adapter
        }
    }

    /**
     * True for middle item, false for 0.
     */
    var defaultFocusToMiddle = true
    var onControlSelectedListener: OnControlSelectedListener? = null
    var onControlClickedListener: OnControlClickedListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?): ViewHolder {
        if (parent == null) {
            throw IllegalArgumentException("Parent should not be null")
        }
        val v = LayoutInflater.from(parent.context)
            .inflate(layoutResId, parent, false)
        return MCLSControlBarViewHolder(
            rootView = v
        )
    }

    override fun onBindViewHolder(viewHolder: ViewHolder?, item: Any?) {
        if (viewHolder == null) {
            return
        }

        if (item == null) {
            return
        }

        val vh = viewHolder as MCLSControlBarViewHolder
        val data = item as BoundData

        if (vh.adapter != data.adapter) {
            vh.adapter = data.adapter
            vh.adapter?.registerObserver(vh.dataObserver)
        }

        vh.presenter = data.presenter
        vh.data = data
        vh.showControls(vh.presenter)
    }

    override fun onUnbindViewHolder(viewHolder: ViewHolder?) {
        val vh = viewHolder as MCLSControlBarViewHolder?
        vh?.adapter?.unregisterObserver(vh.dataObserver)
        vh?.adapter = null
        vh?.data = null
    }
}