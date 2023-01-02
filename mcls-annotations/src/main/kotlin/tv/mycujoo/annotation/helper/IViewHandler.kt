package tv.mycujoo.annotation.helper

import android.animation.ObjectAnimator
import tv.mycujoo.annotation.widget.ScaffoldView

interface IViewHandler {
    fun addAnimation(overlayTag: String, objectAnimator: ObjectAnimator)
    fun removeAnimation(overlayTag: String)
    fun getAnimations(): List<ObjectAnimator>
    fun getAnimationWithTag(id: String): ObjectAnimator?

    fun attachOverlayView(view: ScaffoldView)
    fun detachOverlayView(view: ScaffoldView?)
    fun getOverlayView(id: String): ScaffoldView?

    fun overlayIsNotAttached(tag: String): Boolean
    fun overlayIsAttached(tag: String): Boolean

    fun clearAll()
    fun incrementIdlingResource()
    fun decrementIdlingResource()
}
