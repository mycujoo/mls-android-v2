package tv.mycujoo.annotation.mediator

import tv.mycujoo.annotation.core.IAnnotationFactory
import tv.mycujoo.mclscore.model.Action
import javax.inject.Inject

class AnnotationManager @Inject constructor(
    private val annotationFactory: IAnnotationFactory,
) : IAnnotationManager {
    /**endregion */

    /**region Over-ridden Functions*/
    override fun setLocalActions(actions: List<Action>) {
        annotationFactory.setActions(actions)
    }

    override fun setMCLSActions(actions: List<Action>) {
        annotationFactory.setMCLSActions(actions)
    }

    override fun setCurrentTime(currentPosition: Long) {
        annotationFactory.build(currentPosition)
    }

    /**endregion */
}
