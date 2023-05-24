package tv.mycujoo.mclsplayer.tv.widget

import android.content.Context
import android.graphics.Rect
import android.util.AttributeSet
import android.view.FocusFinder
import android.view.KeyEvent
import android.view.View
import android.view.ViewGroup
import androidx.annotation.RestrictTo
import androidx.constraintlayout.widget.ConstraintLayout
import tv.mycujoo.mclsplayer.tv.R

class MLSPlaybackTransportRowView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : ConstraintLayout(context, attrs, defStyleAttr) {

    /**
     * @hide
     */
    @RestrictTo(RestrictTo.Scope.LIBRARY_GROUP)
    interface OnUnhandledKeyListener {
        /**
         * Returns true if the key event should be consumed.
         */
        fun onUnhandledKey(event: KeyEvent?): Boolean
    }

    var onUnhandledKeyListener: OnUnhandledKeyListener? = null

    override fun dispatchKeyEvent(event: KeyEvent): Boolean {
        return if (super.dispatchKeyEvent(event)) {
            true
        } else onUnhandledKeyListener != null && onUnhandledKeyListener!!.onUnhandledKey(event)
    }

    override fun onRequestFocusInDescendants(
        direction: Int,
        previouslyFocusedRect: Rect?
    ): Boolean {
        val focused = findFocus()
        if (focused != null && focused.requestFocus(direction, previouslyFocusedRect)) {
            return true
        }
        val progress = findViewById<View>(androidx.leanback.R.id.playback_progress)
        if (progress != null && progress.isFocusable) {
            if (progress.requestFocus(direction, previouslyFocusedRect)) {
                return true
            }
        }
        return super.onRequestFocusInDescendants(direction, previouslyFocusedRect)
    }

    override fun focusSearch(focused: View?, direction: Int): View? {
        // when focusSearch vertically, return the next immediate focusable child
        if (focused != null) {
            if (direction == FOCUS_UP) {
                var index = indexOfChild(focusedChild)
                index -= 1
                while (index >= 0) {
                    val view = getChildAt(index)
                    if (view.hasFocusable()) {
                        return view
                    }
                    index--
                }
            } else if (direction == FOCUS_DOWN) {
                var index = indexOfChild(focusedChild)
                index += 1
                while (index < childCount) {
                    val view = getChildAt(index)
                    if (view.hasFocusable()) {
                        return view
                    }
                    index++
                }
            } else if (direction == FOCUS_LEFT || direction == FOCUS_RIGHT) {
                if (focusedChild is ViewGroup) {
                    return FocusFinder.getInstance().findNextFocus(
                        focusedChild as ViewGroup, focused, direction
                    )
                }
            }
        }
        return super.focusSearch(focused, direction)
    }

    override fun hasOverlappingRendering(): Boolean {
        return false
    }
}