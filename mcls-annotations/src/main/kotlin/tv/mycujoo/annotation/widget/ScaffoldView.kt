package tv.mycujoo.annotation.widget

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.annotation.UiThread
import com.caverock.androidsvg.SVG
import org.xmlpull.v1.XmlPullParserException
import timber.log.Timber

class ScaffoldView @JvmOverloads constructor(
    widthPercentage: Float = -1F,
    heightPercentage: Float = -1F,
    context: Context,
    attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private lateinit var svgString: String
    private lateinit var variablePlaceHolder: List<String>
    private lateinit var latestVariableValue: MutableMap<String, Any>
    private val stringManipulator = StringBuilder()

    private val proportionalImageView = ProportionalImageView(
        context,
        widthPercentage,
        heightPercentage,
        attrs,
        defStyleAttr
    )

    init {
        proportionalImageView.scaleType = ImageView.ScaleType.FIT_START
        proportionalImageView.adjustViewBounds = true


        addView(
            proportionalImageView, LayoutParams(
                LayoutParams.MATCH_PARENT,
                LayoutParams.MATCH_PARENT
            )
        )
    }

    fun setSVG(svg: SVG) {
        proportionalImageView.setSVG(svg)
    }

    fun setSVGSource(svgString: String) {
        this.svgString = svgString
    }

    fun setScaleType(scaleType: ImageView.ScaleType) {
        post {
            proportionalImageView.scaleType = scaleType
        }
    }


    fun setVariablePlaceHolder(variablePlaceHolders: List<String>) {
        this.variablePlaceHolder = variablePlaceHolders
        this.latestVariableValue = mutableMapOf()
    }

    fun initialVariables(updatedPair: Pair<String, Any>) {
        if (this::variablePlaceHolder.isInitialized.not() || this::latestVariableValue.isInitialized.not()) {
            return
        }
        if (!variablePlaceHolder.contains(updatedPair.first) || updatedPair.second == "") {
            return
        }

        latestVariableValue[updatedPair.first] = updatedPair.second

    }

    fun onVariableUpdated(
        updatedPair: Pair<String, Any>
    ) {
        if (this::variablePlaceHolder.isInitialized.not() || this::latestVariableValue.isInitialized.not() || this::svgString.isInitialized.not()) {
            return
        }

        if (!variablePlaceHolder.contains(updatedPair.first)) {
            return
        }

        latestVariableValue[updatedPair.first] = updatedPair.second

        stringManipulator.clear()
        stringManipulator.append(svgString)

        if (stringManipulator.isNotEmpty()) {
            variablePlaceHolder.filter { latestVariableValue.contains(it) }.forEach { entry ->
                latestVariableValue[entry]?.let { value ->
                    val start = stringManipulator.indexOf(entry)
                    if (start > -1 && start < stringManipulator.length) {
                        stringManipulator.replace(start, start + entry.length, value.toString())
                    }
                }
            }

            try {
                /**
                 *      Warning!!!
                 *      This is causing some problems when doing high volume of edits per second.
                 *      I don't want to increase allocation for now, but this one needs to be profiled
                 *      in a way to ensure that no Dirty Memory Traces happen.
                 *
                 *      For now though, I'll simple ignore any issues with inflation since it
                 *      doesn't affect the user that much, we rarely inflate more than 2 views at a time
                 *      And this error should not trigger in most cases.
                 */
                setSVG(SVG.getFromString(stringManipulator.toString()))
                stringManipulator.delete(0, stringManipulator.length)
            } catch (e: XmlPullParserException) {
                Timber.e("Error Parsing ${e.stackTraceToString()}")
            }
        }
    }


}
