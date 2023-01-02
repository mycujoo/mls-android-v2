package tv.mycujoo.annotation.annotation

import android.view.View
import androidx.lifecycle.DefaultLifecycleObserver
import tv.mycujoo.mclscore.model.Action

interface IAnnotationView : DefaultLifecycleObserver {
    fun getWidth(): Int

    fun getHeight(): Int

    fun attachPlayer(player: VideoPlayer)

    fun setMCLSActions(actions: List<Action>)

    fun addView(view: View)

    fun post(runnable: Runnable): Boolean

    fun removeView(view: View)

    fun removeAllViewsInLayout()

    fun getChildren(): Sequence<View>
}