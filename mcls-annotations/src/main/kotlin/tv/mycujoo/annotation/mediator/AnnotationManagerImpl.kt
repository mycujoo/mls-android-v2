package tv.mycujoo.annotation.mediator

import tv.mycujoo.annotation.core.IAnnotationFactory
import tv.mycujoo.mclscore.model.AnnotationAction
import javax.inject.Inject

class AnnotationManagerImpl @Inject constructor(
    private val annotationFactory: IAnnotationFactory,
) : AnnotationManager {
    /**endregion */

    /**region Over-ridden Functions*/
    override fun setActions(actions: List<AnnotationAction>) {
        annotationFactory.setActions(actions)
    }

    override fun setTime(currentPosition: Long) {
        annotationFactory.build(currentPosition)
    }

    /**endregion */
}
