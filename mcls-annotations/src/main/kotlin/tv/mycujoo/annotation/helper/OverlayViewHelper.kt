package tv.mycujoo.annotation.helper

import android.view.View
import android.widget.ImageView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.ConstraintSet
import androidx.core.util.Pools
import androidx.core.view.doOnLayout
import timber.log.Timber
import tv.mycujoo.annotation.annotation.IAnnotationView
import tv.mycujoo.annotation.domain.entity.*
import tv.mycujoo.annotation.helper.AnimationClassifierHelper.Companion.hasDynamicIntroAnimation
import tv.mycujoo.annotation.helper.AnimationClassifierHelper.Companion.hasDynamicOutroAnimation
import tv.mycujoo.annotation.helper.AnimationClassifierHelper.Companion.hasStaticIntroAnimation
import tv.mycujoo.annotation.helper.AnimationClassifierHelper.Companion.hasStaticOutroAnimation
import tv.mycujoo.annotation.widget.ProportionalImageView
import tv.mycujoo.annotation.widget.ScaffoldView
import tv.mycujoo.mclscore.entity.AnimationType
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.PositionGuide
import tv.mycujoo.mclscore.model.TransitionSpec
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Helps with View related operations. i.e. Add/Remove overlay view to/from screen.
 *
 */
@Singleton
class OverlayViewHelper @Inject constructor(
    private val overlayHost: IAnnotationView,
    private val viewHandler: IViewHandler,
    private val overlayFactory: IOverlayFactory,
    private val animationFactory: AnimationFactory
) {

    /**region Add view*/

    /**
     * Add overlay view to host view with specified animation. If there is a specified animation, it will be add with amimation,
     * otherwise no animation will be created.
     * This is the only method that should be used for 'Adding' overlay. All other methods are private and considered internal service.
     * @param overlayHost to host to overlay view
     * @param showOverlayAction data needed for type of animation and overlay
     */
    fun addView(showOverlayAction: AnnotationAction.ShowOverlayAction) {
        if (showOverlayAction.introTransitionSpec?.animationType == AnimationType.NONE) {
            addViewWithNoAnimation(showOverlayAction)
        } else {
            addViewWithAnimation(showOverlayAction)
        }
    }
    /**endregion */

    /**region Add view with animation*/
    private fun addViewWithAnimation(showOverlayAction: AnnotationAction.ShowOverlayAction) {
        viewHandler.incrementIdlingResource()

        overlayHost.post {
            val scaffoldView = overlayFactory.createScaffoldView(showOverlayAction)

            val positionGuide = showOverlayAction.viewSpec?.positionGuide ?: PositionGuide(
                left = 0f,
                top = 0f
            )
            val animationType =
                showOverlayAction.introTransitionSpec?.animationType ?: AnimationType.NONE

            val introTransitionSpec = showOverlayAction.introTransitionSpec ?: TransitionSpec(
                offset = 0,
                animationType = animationType,
                animationDuration = 0
            )

            when {
                hasStaticIntroAnimation(animationType) -> {
                    doAddViewWithStaticAnimation(
                        scaffoldView,
                        positionGuide,
                        introTransitionSpec
                    )
                }
                hasDynamicIntroAnimation(animationType) -> {
                    doAddViewWithDynamicAnimation(
                        scaffoldView,
                        positionGuide,
                        introTransitionSpec
                    )
                }
                else -> {
                    // should not happen
                    viewHandler.decrementIdlingResource()
                }
            }
        }

    }

    private fun doAddViewWithDynamicAnimation(
        scaffoldView: ScaffoldView,
        positionGuide: PositionGuide,
        introTransitionSpec: TransitionSpec
    ) {
        if (overlayHost is ConstraintLayout) {
            val constraintSet = ConstraintSet()
            constraintSet.clone(overlayHost)

            val layoutParams = getDefaultLayoutParams()

            applyPositionGuide(
                positionGuide,
                layoutParams,
                scaffoldView
            )

            scaffoldView.layoutParams = layoutParams
            scaffoldView.visibility = View.INVISIBLE
            constraintSet.applyTo(overlayHost)
            viewHandler.attachOverlayView(scaffoldView)

            scaffoldView.doOnLayout {

                val anim = animationFactory.createAddViewDynamicAnimation(
                    overlayHost,
                    scaffoldView,
                    introTransitionSpec,
                    viewHandler
                )
                anim?.start()
                viewHandler.decrementIdlingResource()
            }
        }
    }

    private fun doAddViewWithStaticAnimation(
        scaffoldView: ScaffoldView,
        positionGuide: PositionGuide,
        introTransitionSpec: TransitionSpec
    ) {
        if (overlayHost is ConstraintLayout) {
            val constraintSet = ConstraintSet()
            constraintSet.clone(overlayHost)

            val layoutParams = getDefaultLayoutParams()

            applyPositionGuide(
                positionGuide,
                layoutParams,
                scaffoldView
            )


            constraintSet.applyTo(overlayHost)
            scaffoldView.layoutParams = layoutParams

            viewHandler.attachOverlayView(scaffoldView)

            val animation = animationFactory.createAddViewStaticAnimation(
                scaffoldView,
                introTransitionSpec.animationType,
                introTransitionSpec.animationDuration
            )
            animation?.let {
                viewHandler.addAnimation(scaffoldView.tag as String, animation)
                animation.start()
                viewHandler.decrementIdlingResource()
            }
        }
    }
    /**endregion */


    /**region Add view with NO animation*/
    private fun addViewWithNoAnimation(showOverlayAction: AnnotationAction.ShowOverlayAction) {
        viewHandler.incrementIdlingResource()

        val scaffoldView = overlayFactory.createScaffoldView(showOverlayAction)

        val positionGuide = showOverlayAction.viewSpec?.positionGuide ?: PositionGuide(
            left = 0f,
            top = 0f
        )

        doAddViewWithNoAnimation(
            scaffoldView,
            positionGuide
        )

    }


    private fun doAddViewWithNoAnimation(
        scaffoldView: ScaffoldView,
        positionGuide: PositionGuide
    ) {
        if (overlayHost is ConstraintLayout) {
            overlayHost.post {
                val constraintSet = ConstraintSet()
                constraintSet.clone(overlayHost)

                val layoutParams = getDefaultLayoutParams()

                applyPositionGuide(
                    positionGuide,
                    layoutParams,
                    scaffoldView
                )


                constraintSet.applyTo(overlayHost)
                scaffoldView.layoutParams = layoutParams

                viewHandler.attachOverlayView(scaffoldView)
                scaffoldView.doOnLayout {
                    viewHandler.decrementIdlingResource()
                }
            }
        }
    }
    /**endregion */

    /**region Remove view*/
    /**
     * Remove overlay view from host view with specified animation.
     * @param overlayHost the host that overlay view is displayed in currently
     * @param customId overlay identifier (view tag)
     * @param outroTransitionSpec transition specification needed for outro animation type and duration
     */
    fun removeView(
        customId: String,
        outroTransitionSpec: TransitionSpec?
    ) {
        if (outroTransitionSpec == null || outroTransitionSpec.animationType == AnimationType.NONE) {
            removeViewWithNoAnimation(customId)
        } else {
            removeViewWithAnimation(customId, outroTransitionSpec)
        }
    }

    /**
     * Remove overlay view from host view with specified animation.
     * @param overlayHost the host that overlay view is displayed in currently
     * @param hideOverlayActionEntity hide overlay Action which provides customId for removing overlay view with same identifier as 'Tag'
     */
    fun removeView(
        hideOverlayActionEntity: HideOverlayActionEntity
    ) {
        removeViewWithNoAnimation(hideOverlayActionEntity.customId)
    }

    fun clearScreen() {
        viewHandler.clearAll()
    }

    private fun removeViewWithNoAnimation(
        overlayTag: String
    ) {
        overlayHost.getChildren().filter { it.tag == overlayTag }
            .forEach {
                viewHandler.detachOverlayView(it as ScaffoldView)
            }
        viewHandler.removeAnimation(overlayTag)
    }
    /**endregion */


    /**region Remove view with animation*/
    private fun removeViewWithAnimation(
        actionId: String,
        outroTransitionSpec: TransitionSpec
    ) {
        viewHandler.incrementIdlingResource()

        when {
            hasStaticOutroAnimation(outroTransitionSpec.animationType) -> {
                removeViewWithStaticAnimation(
                    actionId,
                    outroTransitionSpec

                )
            }
            hasDynamicOutroAnimation(outroTransitionSpec.animationType) -> {
                removeViewWithDynamicAnimation(
                    actionId,
                    outroTransitionSpec
                )
            }
            else -> {
                // should not happen
                viewHandler.decrementIdlingResource()
            }
        }
    }

    private fun removeViewWithStaticAnimation(
        actionId: String,
        outroTransitionSpec: TransitionSpec
    ) {
        overlayHost.post {
            overlayHost.getChildren().filter { it.tag == actionId }.forEach { view ->
                view as ScaffoldView

                val animation = animationFactory.createRemoveViewStaticAnimation(
                    overlayHost,
                    actionId,
                    outroTransitionSpec,
                    view,
                    viewHandler
                )

                animation.start()
            }
            viewHandler.decrementIdlingResource()
        }
    }

    private fun removeViewWithDynamicAnimation(
        actionId: String,
        outroTransitionSpec: TransitionSpec
    ) {
        overlayHost.post {
            overlayHost.getChildren().filter { it.tag == actionId }.forEach { view ->
                view as ScaffoldView

                val animation = animationFactory.createRemoveViewDynamicAnimation(
                    overlayHost,
                    actionId,
                    outroTransitionSpec,
                    view,
                    viewHandler
                )

                if (animation == null) {
                    // should not happen
                    Timber.tag("OverlayEntityView").e("animation must not be null")
                    return@forEach
                }

                animation.start()
            }

            viewHandler.decrementIdlingResource()
        }
    }
    /**endregion */


    /**region Add lingering view with animation*/
    private fun addLingeringIntroViewWithAnimation(
        showOverlayAction: AnnotationAction.ShowOverlayAction,
        animationPosition: Long,
        isPlaying: Boolean
    ) {
        viewHandler.incrementIdlingResource()

        if (overlayHost is ConstraintLayout) {
            overlayHost.post {

                val scaffoldView = overlayFactory.createScaffoldView(showOverlayAction)

                scaffoldView.doOnLayout {

                    val animation = animationFactory.createLingeringIntroViewAnimation(
                        overlayHost,
                        scaffoldView,
                        showOverlayAction,
                        animationPosition,
                        isPlaying,
                        viewHandler
                    )

                    if (animation == null) {
                        Timber.tag("OverlayEntityView").e("animation must not be null")
                        return@doOnLayout
                    }
                    viewHandler.decrementIdlingResource()

                }

                val constraintSet = ConstraintSet()
                constraintSet.clone(overlayHost)

                val positionGuide = showOverlayAction.viewSpec?.positionGuide ?: PositionGuide(
                    left = 0f,
                    top = 0f
                )

                val layoutParams = getDefaultLayoutParams()

                applyPositionGuide(positionGuide, layoutParams, scaffoldView)


                scaffoldView.layoutParams = layoutParams
                scaffoldView.visibility = View.INVISIBLE
                constraintSet.applyTo(overlayHost)
                viewHandler.attachOverlayView(scaffoldView)

            }
        }
    }

    private fun updateLingeringIntroOverlay(
        showOverlayAction: AnnotationAction.ShowOverlayAction,
        animationPosition: Long,
        isPlaying: Boolean
    ) {
        viewHandler.incrementIdlingResource()

        overlayHost.post {
            overlayHost.getChildren().firstOrNull { it.tag == showOverlayAction.customId }
                ?.let { _ ->

                    viewHandler.getAnimationWithTag(showOverlayAction.customId)?.cancel()
                    viewHandler.removeAnimation(showOverlayAction.customId)

                    val scaffoldView = viewHandler.getOverlayView(showOverlayAction.customId)

                    scaffoldView?.let {
                        viewHandler.detachOverlayView(
                            it
                        )
                    }


                    addLingeringIntroViewWithAnimation(
                        showOverlayAction,
                        animationPosition,
                        isPlaying
                    )
                }
            viewHandler.decrementIdlingResource()
        }

    }


    private fun addLingeringOutroViewWithAnimation(
        showOverlayAction: AnnotationAction.ShowOverlayAction,
        animationPosition: Long,
        isPlaying: Boolean
    ) {
        if (overlayHost is ConstraintLayout) {
            overlayHost.post {
                val scaffoldView = overlayFactory.createScaffoldView(showOverlayAction)

                scaffoldView.doOnLayout {
                    animationFactory.createLingeringOutroAnimation(
                        overlayHost,
                        scaffoldView,
                        showOverlayAction,
                        animationPosition,
                        isPlaying,
                        viewHandler
                    )
                }

                val constraintSet = ConstraintSet()
                constraintSet.clone(overlayHost)
                val positionGuide = showOverlayAction.viewSpec?.positionGuide
                    ?: // should not happen
                    return@post

                val layoutParams = getDefaultLayoutParams()

                applyPositionGuide(positionGuide, layoutParams, scaffoldView)

                scaffoldView.layoutParams = layoutParams
                scaffoldView.visibility = View.INVISIBLE
                constraintSet.applyTo(overlayHost)
                viewHandler.attachOverlayView(scaffoldView)
            }
        }
    }

    private fun updateLingeringOutroOverlay(
        showOverlayAction: AnnotationAction.ShowOverlayAction,
        animationPosition: Long,
        isPlaying: Boolean
    ) {
        val scaffoldView = viewHandler.getOverlayView(showOverlayAction.customId) ?: return

        overlayHost.post {
            viewHandler.getAnimationWithTag(showOverlayAction.customId)?.cancel()
            viewHandler.removeAnimation(showOverlayAction.customId)

            viewHandler.detachOverlayView(
                scaffoldView
            )

            addLingeringOutroViewWithAnimation(
                showOverlayAction,
                animationPosition,
                isPlaying
            )
        }

    }

    fun addOrUpdateLingeringMidwayOverlay(
        showOverlayAction: AnnotationAction.ShowOverlayAction
    ) {
        if (viewHandler.overlayIsAttached(showOverlayAction.customId)) {
            val scaffoldView = viewHandler.getOverlayView(showOverlayAction.customId) ?: return
            overlayHost.post {
                updateLingeringMidway(showOverlayAction, scaffoldView)
            }
        } else {
            overlayHost.post {
                addViewWithNoAnimation(showOverlayAction)
            }
        }
    }

    private val constraintLayoutPool = Pools.SynchronizedPool<ConstraintSet>(10)

    private fun updateLingeringMidway(
        showOverlayAction: AnnotationAction.ShowOverlayAction,
        scaffoldView: ScaffoldView
    ) {
        if (overlayHost is ConstraintLayout) {
            var constraintSet = constraintLayoutPool.acquire()
            if (constraintSet == null) {
                constraintSet = ConstraintSet()
                constraintSet.clone(overlayHost)
            }

            val positionGuide = showOverlayAction.viewSpec?.positionGuide ?: PositionGuide(
                left = 0f,
                top = 0f
            )

            val layoutParams = getDefaultLayoutParams()

            applyPositionGuide(positionGuide, layoutParams, scaffoldView)

            scaffoldView.layoutParams = layoutParams

            scaffoldView.visibility = View.VISIBLE
            constraintSet.applyTo(overlayHost)
            constraintLayoutPool.release(constraintSet)
        }
    }


    /**endregion */

    /**region Add or Update lingering intro view*/
    fun addOrUpdateLingeringIntroOverlay(
        showOverlayAction: AnnotationAction.ShowOverlayAction,
        animationPosition: Long,
        isPlaying: Boolean
    ) {
        if (viewHandler.overlayIsAttached(showOverlayAction.customId)) {
            updateLingeringIntroOverlay(
                showOverlayAction,
                animationPosition,
                isPlaying
            )
        } else {
            addLingeringIntroViewWithAnimation(
                showOverlayAction,
                animationPosition,
                isPlaying
            )
        }
    }
    /**endregion */

    /**region Add or Update lingering outro view*/
    fun addOrUpdateLingeringOutroOverlay(
        showOverlayAction: AnnotationAction.ShowOverlayAction,
        animationPosition: Long,
        isPlaying: Boolean
    ) {
        if (viewHandler.overlayIsAttached(showOverlayAction.customId)) {
            updateLingeringOutroOverlay(
                showOverlayAction,
                animationPosition,
                isPlaying
            )
        } else {
            addLingeringOutroViewWithAnimation(
                showOverlayAction,
                animationPosition,
                isPlaying
            )
        }
    }
    /**endregion */

    /**region Positioning Functions*/
    /**
     * This region provides methods to position a view (overlay view in this case) in a host view,
     * based on Position Guide provided.
     *
     * @param positionGuide guides how a view should be positioned on screen.
     * i.e. distance to left/right/top/bottom axis of screen in percentage.
     *
     * @param layoutParams layout params needed for positioning the view
     * @param scaffoldView the overlay view itself which is going to be positioned
     */
    private fun applyPositionGuide(
        positionGuide: PositionGuide,
        layoutParams: ConstraintLayout.LayoutParams,
        scaffoldView: ScaffoldView
    ) {

        positionGuide.left?.let {
            if (it < 0F) {
                return@let
            }
            setLeftConstraints(
                it,
                layoutParams,
                scaffoldView
            )
        }
        positionGuide.right?.let {
            if (it < 0F) {
                return@let
            }
            setRightConstraints(
                it,
                layoutParams
            )
        }
        positionGuide.top?.let {
            if (it < 0F) {
                return@let
            }
            setTopConstraints(
                it,
                layoutParams
            )
        }
        positionGuide.bottom?.let {
            if (it < 0F) {
                return@let
            }
            setBottomConstraints(
                it,
                layoutParams,
                scaffoldView
            )
        }
        positionGuide.vCenter?.let {
            if (it > 50F || it < -50F) {
                return@let
            }
            setVCenterConstraints(layoutParams, it)
        }
        positionGuide.hCenter?.let {
            if (it > 50F || it < -50F) {
                return@let
            }
            setHCenterConstrains(layoutParams, it)
        }
    }


    private fun setHCenterConstrains(
        layoutParams: ConstraintLayout.LayoutParams,
        it: Float
    ) {
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.horizontalBias = (0.5F + it / 100)
    }

    private fun setVCenterConstraints(
        layoutParams: ConstraintLayout.LayoutParams,
        it: Float
    ) {
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.verticalBias = (0.5F + it / 100)
    }

    private fun setBottomConstraints(
        it: Float,
        layoutParams: ConstraintLayout.LayoutParams,
        proportionalImageView: View
    ) {
        layoutParams.verticalBias = 1F - (it / 100)

        if (proportionalImageView is ProportionalImageView) {
            proportionalImageView.scaleType = ImageView.ScaleType.FIT_END
        } else {
            (proportionalImageView as ScaffoldView).setScaleType(ImageView.ScaleType.FIT_END)
        }
    }

    private fun setTopConstraints(
        it: Float,
        layoutParams: ConstraintLayout.LayoutParams
    ) {
        layoutParams.verticalBias = it / 100
    }

    private fun setRightConstraints(
        it: Float,
        layoutParams: ConstraintLayout.LayoutParams
    ) {
        layoutParams.horizontalBias = 1F - (it / 100)
    }

    private fun setLeftConstraints(
        it: Float,
        layoutParams: ConstraintLayout.LayoutParams,
        proportionalImageView: View
    ) {
        layoutParams.horizontalBias = it / 100
        if (proportionalImageView is ProportionalImageView) {
            proportionalImageView.scaleType = ImageView.ScaleType.FIT_START
        } else {
            (proportionalImageView as ScaffoldView).setScaleType(ImageView.ScaleType.FIT_START)
        }
    }

    private fun getDefaultLayoutParams(): ConstraintLayout.LayoutParams {
        val layoutParams = ConstraintLayout.LayoutParams(
            ConstraintLayout.LayoutParams.WRAP_CONTENT,
            ConstraintLayout.LayoutParams.WRAP_CONTENT
        )
        layoutParams.topToTop = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.bottomToBottom = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.leftToLeft = ConstraintLayout.LayoutParams.PARENT_ID
        layoutParams.rightToRight = ConstraintLayout.LayoutParams.PARENT_ID

        return layoutParams
    }
    /**endregion */
}
