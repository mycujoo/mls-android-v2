package tv.mycujoo.annotation.helper

import android.content.Context
import android.view.View
import com.caverock.androidsvg.SVG
import timber.log.Timber
import tv.mycujoo.annotation.widget.ScaffoldView
import tv.mycujoo.mclscore.model.AnnotationAction
import javax.inject.Inject
import javax.inject.Singleton


/**
 * Create overlay, which is the view used for displaying Annotation Action on screen.
 *
 *
 * @param context context to create View from
 * @param variableKeeper provides observables to for variables defined/used in Overlay
 */
@Singleton
class OverlayFactory @Inject constructor(
    private val context: Context,
    private val variableKeeper: tv.mycujoo.annotation.manager.IVariableKeeper
) : IOverlayFactory {

    /**
     * @param showOverlayAction Action which provides data of to be created view
     */
    override fun createScaffoldView(
        showOverlayAction: AnnotationAction.ShowOverlayAction,
    ): ScaffoldView {

        val size = showOverlayAction.viewSpec?.size ?: Pair(-1f, -1f)
        val scaffoldView = ScaffoldView(size.first, size.second, context)
        scaffoldView.id = View.generateViewId()
        scaffoldView.tag = showOverlayAction.customId

        scaffoldView.setVariablePlaceHolder(showOverlayAction.placeHolders)

        showOverlayAction.placeHolders.forEach { entry ->
            // VALUE of place-holder, is the KEY in the set_variable map
            variableKeeper.getTimerNames().firstOrNull {
                it == entry
            }?.let {
                variableKeeper.observeOnTimer(entry) { scaffoldView.onVariableUpdated(it) }
                scaffoldView.initialVariables(Pair(entry, variableKeeper.getValue(entry)))
            }

            variableKeeper.getVariableNames().find { it == entry }?.let {
                variableKeeper.observeOnVariable(entry) { scaffoldView.onVariableUpdated(it) }
                scaffoldView.initialVariables(Pair(entry, variableKeeper.getValue(entry)))
            }
        }

        try {
            var rawString = StringBuffer(showOverlayAction.svgData?.svgString ?: "")

            if (rawString.isEmpty()) {
                return scaffoldView
            }

            showOverlayAction.placeHolders.forEach { placeHolder ->
                val varValue = variableKeeper.getValue(placeHolder)
                val startIndex = rawString.indexOf(placeHolder)
                if (startIndex != -1 && startIndex + placeHolder.length <= rawString.length) {
                    rawString = rawString.replace(
                        rawString.indexOf(placeHolder),
                        rawString.indexOf(placeHolder) + placeHolder.length,
                        varValue,
                    )
                }

            }

            scaffoldView.setSVG(SVG.getFromString(rawString.toString()))

            showOverlayAction.svgData?.svgString?.let {
                scaffoldView.setSVGSource(it)
            }

            rawString.delete(0, rawString.length)

        } catch (e: Exception) {
            Timber.tag("OverlayViewHelper").w("Exception => ".plus(e.message))
        }

        return scaffoldView

    }
}
