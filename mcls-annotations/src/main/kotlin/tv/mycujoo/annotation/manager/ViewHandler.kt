package tv.mycujoo.annotation.manager

import android.animation.ObjectAnimator
import android.os.Handler
import android.os.Looper
import androidx.test.espresso.idling.CountingIdlingResource
import timber.log.Timber
import tv.mycujoo.annotation.annotation.IAnnotationView
import tv.mycujoo.annotation.di.CountingIdlingResourceViewIdentifierManager
import tv.mycujoo.annotation.helper.IViewHandler
import tv.mycujoo.annotation.widget.ScaffoldView
import javax.inject.Inject


open class ViewHandler @Inject constructor(
    @CountingIdlingResourceViewIdentifierManager val idlingResource: CountingIdlingResource,
    private val overlayHost: IAnnotationView
) : IViewHandler {

    private var viewIdToIdMap = mutableMapOf<String, Int>()
    private var animations = ArrayList<Pair<String, ObjectAnimator>>()

    private val attachedViewList: ArrayList<ScaffoldView> = ArrayList()
    /**endregion */

    /**region Animation*/
    override fun addAnimation(
        overlayTag: String,
        objectAnimator: ObjectAnimator
    ) {
        animations.add(Pair(overlayTag, objectAnimator))
    }

    override fun removeAnimation(overlayTag: String) {
        val pair = animations.firstOrNull { it.first == overlayTag }
        animations.remove(pair)
    }

    override fun getAnimations(): List<ObjectAnimator> {
        return animations.map { it.second }
    }

    override fun getAnimationWithTag(id: String): ObjectAnimator? {
        return animations.firstOrNull { it.first == id }?.second
    }
    /**endregion */

    /**region Overlay views*/
    override fun attachOverlayView(view: ScaffoldView) {
        if (view.tag == null || (view.tag is String).not()) {
            Timber.w("overlay tag should not be null")
            return
        }
        val viewTag = view.tag as String
        if (attachedViewList.any {
                it.tag == viewTag
            }) {
            Timber.w("Should not add an already active view")
        } else {
            attachedViewList.add(view)
            overlayHost.addView(view)
        }
    }

    override fun detachOverlayView(view: ScaffoldView?) {
        if (view == null) {
            return
        }

        if (view.tag == null || (view.tag is String).not()) {
            Timber.w("overlay tag should not be null [detachOverlay()]")
            return
        }

        attachedViewList.remove(view)
        Handler(Looper.getMainLooper()).post {
            overlayHost.removeView(view)
        }
    }

    override fun getOverlayView(id: String): ScaffoldView? {
        return attachedViewList.firstOrNull { it.tag == id }
    }

    /**endregion */

    /**region Overlay objects*/
    override fun overlayIsNotAttached(tag: String): Boolean {
        return attachedViewList.none { it.tag == tag }
    }

    override fun overlayIsAttached(tag: String): Boolean {
        return attachedViewList.any { it.tag == tag }
    }

    /**endregion */

    /**region msc*/
    override fun clearAll() {
        overlayHost.removeAllViewsInLayout()

        attachedViewList.clear()
        animations.clear()
        viewIdToIdMap.clear()
    }

    override fun incrementIdlingResource() {
        idlingResource.increment()
    }


    override fun decrementIdlingResource() {
        if (idlingResource.isIdleNow.not()) {
            idlingResource.decrement()
        }
    }
    /**endregion */

}
