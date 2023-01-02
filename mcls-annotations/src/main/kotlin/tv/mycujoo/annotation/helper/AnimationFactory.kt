package tv.mycujoo.annotation.helper

import android.animation.Animator
import android.animation.ObjectAnimator
import android.view.View
import tv.mycujoo.annotation.annotation.IAnnotationView
import tv.mycujoo.annotation.widget.ScaffoldView
import tv.mycujoo.mclscore.entity.AnimationType
import tv.mycujoo.mclscore.model.Action
import tv.mycujoo.mclscore.model.TransitionSpec
import javax.inject.Inject


/**
 * Creates Android animation object 'ObjectAnimator' with given parameters.
 * Parameter used in creating animation,
 * Each animation needs a combination of these to be created:
 *
 * @see ScaffoldView
 * @see AnimationType
 * @see TransitionSpec
 */
open class AnimationFactory @Inject constructor() {
    open fun createAddViewStaticAnimation(
        scaffoldView: ScaffoldView,
        animationType: AnimationType,
        animationDuration: Long
    ): ObjectAnimator? {
        val animation: ObjectAnimator?
        when (animationType) {
            AnimationType.FADE_IN -> {
                animation = ObjectAnimator.ofFloat(scaffoldView, View.ALPHA, 0F, 1F)
                animation.duration = animationDuration
            }
            else -> {
                // should not happen
                animation = null
            }

        }
        return animation
    }

    open fun createAddViewDynamicAnimation(
        overlayHost: IAnnotationView,
        scaffoldView: ScaffoldView,
        introTransitionSpec: TransitionSpec,
        viewHandler: IViewHandler
    ): ObjectAnimator? {
        val x = scaffoldView.x
        val y = scaffoldView.y

        var animation: ObjectAnimator? = null


        when (introTransitionSpec.animationType) {
            AnimationType.SLIDE_FROM_LEFT -> {
                scaffoldView.x =
                    -scaffoldView.width.toFloat()
                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.X,
                    scaffoldView.x,
                    x
                )

            }
            AnimationType.SLIDE_FROM_TOP -> {
                scaffoldView.y =
                    -scaffoldView.height.toFloat()
                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.Y,
                    scaffoldView.y,
                    y
                )
            }
            AnimationType.SLIDE_FROM_RIGHT -> {
                scaffoldView.x = overlayHost.getWidth().toFloat()
                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.X,
                    scaffoldView.x,
                    x
                )
            }
            AnimationType.SLIDE_FROM_BOTTOM -> {
                scaffoldView.y =
                    overlayHost.getHeight().toFloat()
                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.Y,
                    scaffoldView.y,
                    y
                )
            }
            else -> {
                // should not happen
            }
        }

        if (animation != null) {
            animation.duration = introTransitionSpec.animationDuration
            animation.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator) {
                }

                override fun onAnimationEnd(animation: Animator) {
                }

                override fun onAnimationCancel(animation: Animator) {

                }

                override fun onAnimationStart(animation: Animator) {
                    scaffoldView.visibility = View.VISIBLE
                }

            })
            viewHandler.addAnimation(
                scaffoldView.tag as String,
                animation
            )
        }

        return animation

    }

    open fun createRemoveViewStaticAnimation(
        overlayHost: IAnnotationView,
        showOverlayAction: Action.ShowOverlayAction,
        overlayView: ScaffoldView,
        viewHandler: IViewHandler
    ): ObjectAnimator {
        val animation = ObjectAnimator.ofFloat(overlayView, View.ALPHA, 1F, 0F)
        animation.duration = showOverlayAction.outroTransitionSpec!!.animationDuration

        animation.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                viewHandler.detachOverlayView(overlayView)
                viewHandler.removeAnimation(showOverlayAction.id)
            }

            override fun onAnimationRepeat(animation: Animator) {
            }

            override fun onAnimationCancel(animation: Animator) {
            }

        })

        viewHandler.addAnimation(showOverlayAction.id, animation)

        return animation

    }

    open fun createRemoveViewStaticAnimation(
        overlayHost: IAnnotationView,
        actionId: String,
        outroTransitionSpec: TransitionSpec,
        overlayView: ScaffoldView,
        viewHandler: IViewHandler
    ): ObjectAnimator {
        val animation = ObjectAnimator.ofFloat(overlayView, View.ALPHA, 1F, 0F)
        animation.duration = outroTransitionSpec.animationDuration

        animation.addListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(animation: Animator) {
            }

            override fun onAnimationEnd(animation: Animator) {
                viewHandler.detachOverlayView(overlayView)
                viewHandler.removeAnimation(actionId)
            }

            override fun onAnimationRepeat(animation: Animator) {
            }

            override fun onAnimationCancel(animation: Animator) {
            }

        })

        viewHandler.addAnimation(actionId, animation)

        return animation

    }

    open fun createRemoveViewDynamicAnimation(
        overlayHost: IAnnotationView,
        actionId: String,
        outroTransitionSpec: TransitionSpec,
        view: ScaffoldView,
        viewHandler: IViewHandler
    ): ObjectAnimator? {
        var animation: ObjectAnimator? = null

        when (outroTransitionSpec.animationType) {
            AnimationType.SLIDE_TO_LEFT -> {
                animation = ObjectAnimator.ofFloat(
                    view,
                    View.X,
                    view.x,
                    -view.width.toFloat()
                )
            }
            AnimationType.SLIDE_TO_TOP -> {
                animation = ObjectAnimator.ofFloat(
                    view,
                    View.Y,
                    view.y,
                    -view.height.toFloat()
                )
            }
            AnimationType.SLIDE_TO_RIGHT -> {
                animation = ObjectAnimator.ofFloat(
                    view,
                    View.X,
                    view.x,
                    overlayHost.getWidth().toFloat()
                )
            }
            AnimationType.SLIDE_TO_BOTTOM -> {
                animation = ObjectAnimator.ofFloat(
                    view,
                    View.Y,
                    view.y,
                    overlayHost.getHeight().toFloat()
                )
            }
            else -> {
                // should not happen
            }
        }

        if (animation != null) {
            animation.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator) {
                }

                override fun onAnimationEnd(animation: Animator) {
                    viewHandler.detachOverlayView(view)
                    viewHandler.removeAnimation(actionId)
                }

                override fun onAnimationCancel(animation: Animator) {

                }

                override fun onAnimationStart(animation: Animator) {
                }

            })

            animation.duration = outroTransitionSpec.animationDuration
            viewHandler.addAnimation(actionId, animation)

        }
        return animation

    }

    open fun createLingeringIntroViewAnimation(
        overlayHost: IAnnotationView,
        scaffoldView: ScaffoldView,
        overlayEntity: Action.ShowOverlayAction,
        animationPosition: Long,
        isPlaying: Boolean,
        viewHandler: IViewHandler
    ): ObjectAnimator? {
        val x = scaffoldView.x
        val y = scaffoldView.y

        var animation: ObjectAnimator? = null


        when (overlayEntity.introTransitionSpec!!.animationType) {
            AnimationType.FADE_IN -> {
                scaffoldView.x =
                    -scaffoldView.width.toFloat()
                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.ALPHA,
                    0F,
                    1F
                )
            }
            AnimationType.SLIDE_FROM_LEFT -> {
                scaffoldView.x =
                    -scaffoldView.width.toFloat()
                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.X,
                    scaffoldView.x,
                    x
                )
            }
            AnimationType.SLIDE_FROM_TOP -> {
                scaffoldView.y =
                    -scaffoldView.height.toFloat()
                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.Y,
                    scaffoldView.y,
                    y
                )
            }
            AnimationType.SLIDE_FROM_RIGHT -> {
                scaffoldView.x = overlayHost.getWidth().toFloat()
                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.X,
                    scaffoldView.x,
                    x
                )
            }
            AnimationType.SLIDE_FROM_BOTTOM -> {
                scaffoldView.y =
                    overlayHost.getHeight().toFloat()
                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.Y,
                    scaffoldView.y,
                    y
                )
            }
            else -> {
                // should not happen
            }
        }

        if (animation != null) {
            animation.duration =
                overlayEntity.introTransitionSpec?.animationDuration ?: 0
            animation.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator) {
                }

                override fun onAnimationEnd(animation: Animator) {
                    viewHandler.removeAnimation(overlayEntity.id)
                }

                override fun onAnimationCancel(animation: Animator) {

                }

                override fun onAnimationStart(animation: Animator) {
                    scaffoldView.visibility = View.VISIBLE

                }

            })

            viewHandler.addAnimation(
                overlayEntity.id,
                animation
            )
            animation.start()
            animation.currentPlayTime = animationPosition
            if (isPlaying) {
                animation.resume()
            } else {
                animation.pause()
            }
        }

        return animation

    }

    open fun createLingeringOutroAnimation(
        overlayHost: IAnnotationView,
        scaffoldView: ScaffoldView,
        overlayEntity: Action.ShowOverlayAction,
        animationPosition: Long,
        isPlaying: Boolean,
        viewHandler: IViewHandler
    ): ObjectAnimator? {
        var animation: ObjectAnimator? = null

        when (overlayEntity.outroTransitionSpec!!.animationType) {
            AnimationType.FADE_OUT -> {
                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.ALPHA,
                    1F,
                    0F
                )
            }
            AnimationType.SLIDE_TO_LEFT -> {

                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.X,
                    scaffoldView.x,
                    -scaffoldView.width.toFloat()
                )

            }
            AnimationType.SLIDE_TO_TOP -> {
                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.Y,
                    scaffoldView.y,
                    -overlayHost.getHeight().toFloat()
                )
            }
            AnimationType.SLIDE_TO_RIGHT -> {
                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.X,
                    scaffoldView.x,
                    overlayHost.getHeight().toFloat()
                )

            }
            AnimationType.SLIDE_TO_BOTTOM -> {
                animation = ObjectAnimator.ofFloat(
                    scaffoldView,
                    View.Y,
                    scaffoldView.y,
                    overlayHost.getHeight().toFloat()
                )
            }
            else -> {
                // should not happen
            }
        }

        if (animation != null) {
            animation.duration =
                overlayEntity.outroTransitionSpec?.animationDuration ?: 0
            animation.addListener(object : Animator.AnimatorListener {
                override fun onAnimationRepeat(animation: Animator) {
                }

                override fun onAnimationEnd(animation: Animator) {
                    viewHandler.removeAnimation(overlayEntity.id)
                    viewHandler.detachOverlayView(
                        scaffoldView
                    )
                }

                override fun onAnimationCancel(animation: Animator) {

                }

                override fun onAnimationStart(animation: Animator) {
                    scaffoldView.visibility = View.VISIBLE
                }

            })

            viewHandler.addAnimation(
                overlayEntity.id,
                animation
            )
            animation.start()
            animation.currentPlayTime = animationPosition
            if (isPlaying) {
                animation.resume()
            } else {
                animation.pause()
            }
        }


        return animation
    }
}