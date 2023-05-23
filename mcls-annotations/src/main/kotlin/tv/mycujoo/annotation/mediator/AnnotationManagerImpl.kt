package tv.mycujoo.annotation.mediator

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import tv.mycujoo.annotation.annotation.VideoPlayer
import tv.mycujoo.annotation.core.IAnnotationFactory
import tv.mycujoo.mclscore.model.AnnotationAction
import javax.inject.Inject

class AnnotationManagerImpl @Inject constructor(
    private val annotationFactory: IAnnotationFactory,
) : AnnotationManager {
    /**endregion */

    lateinit var player: VideoPlayer
    private val tickerFlow = flow {
        while (true) {
            emit(Unit)
            delay(1000)
        }
    }

    private lateinit var scope: CoroutineScope

    /**region Over-ridden Functions*/
    override fun setActions(actions: List<AnnotationAction>) {
        annotationFactory.setActions(actions)
    }

    override fun setTime(currentPosition: Long) {
        annotationFactory.build(currentPosition)
    }

    override fun attachPlayer(videoPlayer: VideoPlayer) {
        scope = CoroutineScope(Dispatchers.Main)
        this.player = videoPlayer

        scope.launch {
            tickerFlow.collect {
                annotationFactory.build(player.currentPosition())
            }
        }
    }

    override fun release() {
        annotationFactory.setActions(emptyList())
        scope.cancel()
    }

    /**endregion */
}
