package tv.mycujoo.mclsnetwork.domain.mapper

import tv.mycujoo.mclscore.entity.ScreenTimerDirection
import tv.mycujoo.mclscore.entity.ScreenTimerFormat
import tv.mycujoo.mclscore.model.PositionGuide
import tv.mycujoo.mclscore.model.Variable
import tv.mycujoo.mclsnetwork.domain.entity.*

class DataMapper {
    companion object {
        private const val INVALID_STRING_VALUE = "-1"
        private const val INVALID_LONG_VALUE = -1L
        private const val INVALID_INT_VALUE = -1
        private const val INVALID_FLOAT_VALUE = -1F

        fun extractShowOverlayRelatedData(rawDataMap: Map<String, Any>?): ExtractedShowOverlayRelatedData? {
            if (rawDataMap == null) {
                return null
            }

            var svgUrl: String? = null
            var duration: Long? = null
            var positionGuide: PositionGuide? = null
            val sizePair = MutablePair(INVALID_FLOAT_VALUE, INVALID_FLOAT_VALUE)

            var introAnimationType = tv.mycujoo.mclscore.entity.AnimationType.NONE
            var introAnimationDuration = INVALID_LONG_VALUE
            var outroAnimationType = tv.mycujoo.mclscore.entity.AnimationType.NONE
            var outroAnimationDuration = INVALID_LONG_VALUE

            var variablePlaceHolders = emptyList<String>()
            var customId: String? = null


            rawDataMap.let { data ->
                data.keys.forEach { key ->
                    val any = data[key]
                    when (key) {
                        "custom_id" -> {
                            any?.let { customId = it as String }
                        }
                        "svg_url" -> {
                            any?.let { svgUrl = it as String }
                        }
                        "position" -> {
                            any?.let { positionGuide = extractPositionGuide(it) }
                        }
                        "size" -> {
                            any?.let { extractSize(sizePair, it) }
                        }
                        "duration" -> {
                            any?.let {
                                duration = when (it) {
                                    is Long -> {
                                        it
                                    }
                                    else -> {
                                        (it as Double).toLong()
                                    }
                                }
                            }

                        }
                        "animatein_type" -> {
                            any?.let {
                                introAnimationType = tv.mycujoo.mclscore.entity.AnimationType.fromValueOrNone(it as String)
                            }
                        }
                        "animatein_duration" -> {
                            any?.let {
                                introAnimationDuration = when (it) {
                                    is Long -> {
                                        it
                                    }
                                    else -> {
                                        (it as Double).toLong()
                                    }
                                }
                            }

                        }
                        "animateout_type" -> {
                            any?.let {
                                outroAnimationType = tv.mycujoo.mclscore.entity.AnimationType.fromValueOrNone(it as String)
                            }
                        }
                        "animateout_duration" -> {
                            any?.let {
                                outroAnimationDuration = when (it) {
                                    is Long -> {
                                        it
                                    }
                                    else -> {
                                        (it as Double).toLong()
                                    }
                                }
                            }
                        }
                        "variables" -> {
                            any?.let { variablePlaceHolders = it as List<String> }
                        }

                        else -> {
                        }
                    }
                }
                if (svgUrl == null || positionGuide == null) {
                    return null
                }
                return ExtractedShowOverlayRelatedData(
                    customId,
                    svgUrl!!,
                    duration,
                    positionGuide!!,
                    Pair(sizePair.first, sizePair.second),
                    introAnimationType,
                    introAnimationDuration,
                    outroAnimationType,
                    outroAnimationDuration,
                    variablePlaceHolders
                )
            }
        }

        fun extractHideOverlayRelatedData(rawDataMap: Map<String, Any>?): ExtractedHideOverlayRelatedData? {
            if (rawDataMap == null) {
                return null
            }

            var newId: String? = null
            var outroAnimationType = tv.mycujoo.mclscore.entity.AnimationType.NONE
            var outroAnimationDuration = INVALID_LONG_VALUE

            rawDataMap.let { data ->
                data.keys.forEach { key ->
                    val any = data[key]
                    when (key) {
                        "custom_id" -> {
                            any?.let { newId = it as String }
                        }
                        "animateout_type" -> {
                            any?.let {
                                outroAnimationType = tv.mycujoo.mclscore.entity.AnimationType.fromValueOrNone(it as String)
                            }
                        }
                        "animateout_duration" -> {
                            any?.let {
                                outroAnimationDuration = when (it) {
                                    is Long -> {
                                        it
                                    }
                                    else -> {
                                        (it as Double).toLong()
                                    }
                                }
                            }
                        }
                        else -> {
                            // do nothing
                        }
                    }
                }
                if (newId == null) {
                    return null
                }
                return ExtractedHideOverlayRelatedData(
                    newId!!,
                    outroAnimationType,
                    outroAnimationDuration
                )
            }
        }

        fun extractReshowOverlayRelatedData(rawDataMap: Map<String, Any>?): String? {
            if (rawDataMap == null) {
                return null
            }

            var customId: String? = null

            rawDataMap.let { data ->
                data.keys.forEach { key ->
                    val any = data[key]
                    when (key) {
                        "custom_id" -> {
                            any?.let { customId = it as String }
                        }
                    }
                }
            }
            return customId
        }

        fun extractTimerRelatedData(rawDataMap: Map<String, Any>?): ExtractedTimerRelatedData? {
            if (rawDataMap == null) {
                return null
            }

            var name = INVALID_STRING_VALUE
            var format = ScreenTimerFormat.MINUTES_SECONDS
            var direction = ScreenTimerDirection.UP
            var startValue = INVALID_LONG_VALUE
            var step = INVALID_LONG_VALUE
            var capValue = INVALID_LONG_VALUE
            var value = 0L

            rawDataMap.let { data ->
                data.keys.forEach { key ->
                    val any = data[key]
                    when (key) {

                        "name" -> {
                            any?.let { name = it as String }
                        }
                        "format" -> {
                            any?.let { format = ScreenTimerFormat.fromValueOrUnknown(it as String) }
                        }
                        "direction" -> {
                            any?.let { direction = ScreenTimerDirection.fromValue(it as String) }
                        }
                        "start_value" -> {
                            any?.let {
                                when (it) {
                                    is Double -> {
                                        startValue = it.toLong()
                                    }
                                    is Long -> {
                                        startValue = it
                                    }
                                    else -> {
                                        // should not happen
                                    }
                                }
                            }
                        }
                        "step" -> {
                            any?.let {
                                when (it) {
                                    is Double -> {
                                        step = it.toLong()
                                    }
                                    is Long -> {
                                        step = it
                                    }
                                    else -> {
                                        // should not happen
                                    }
                                }
                            }
                        }
                        "cap_value" -> {
                            any?.let {
                                when (it) {
                                    is Double -> {
                                        capValue = it.toLong()
                                    }
                                    is Long -> {
                                        capValue = it
                                    }
                                    else -> {
                                        // should not happen
                                    }
                                }
                            }
                        }
                        "value" -> {
                            any?.let {
                                when (it) {
                                    is Double -> {
                                        value = it.toLong()
                                    }
                                    is Long -> {
                                        value = it
                                    }
                                    else -> {
                                        // should not happen
                                    }
                                }
                            }
                        }
                        else -> {
                        }
                    }
                }

                return ExtractedTimerRelatedData(
                    name,
                    format,
                    direction,
                    startValue,
                    step,
                    capValue,
                    value
                )
            }
        }

        fun mapToVariable(rawDataMap: Map<String, Any>?): Variable {
            val data = extractSetVariableData(rawDataMap)
            if (data?.name == null) {
                return Variable.InvalidVariable()
            }

            return when (data.variableType) {
                VariableType.UNSPECIFIED -> Variable.InvalidVariable()
                VariableType.DOUBLE -> Variable.DoubleVariable(
                    name = data.name,
                    value = data.variableValue as Double,
                    doublePrecision = data.variableDoublePrecision
                )
                VariableType.LONG -> {
                    Variable.LongVariable(
                        name = data.name,
                        value = data.variableValue as Long
                    )
                }
                VariableType.STRING -> {
                    Variable.StringVariable(
                        name = data.name,
                        value = data.variableValue as String
                    )
                }
            }
        }

        private fun extractSetVariableData(rawDataMap: Map<String, Any>?): ExtractedSetVariableData? {
            if (rawDataMap == null) {
                return null
            }

            var variableName: String? = null
            var variableType = VariableType.UNSPECIFIED
            var variableValue: Any? = null
            var variableDoublePrecision: Int? = null

            rawDataMap.let { data ->
                data.keys.forEach { key ->
                    val any = data[key]
                    when (key) {
                        "name" -> {
                            any?.let { variableName = it as String }
                        }
                        "type" -> {
                            any?.let { variableType = VariableType.fromValueOrNone(it as String) }
                        }
                        "double_precision" -> {
                            any?.let {
                                when (it) {
                                    is Double -> {
                                        variableDoublePrecision = it.toInt()
                                    }
                                    is Int -> {
                                        variableDoublePrecision = it
                                    }
                                    else -> {
                                        // should not happen
                                    }
                                }
                            }
                        }
                    }
                }
            }

            when (rawDataMap["value"]) {
                is Double -> {
                    when (variableType) {
                        VariableType.DOUBLE -> {
                            variableValue =
                                rawDataMap["value"] as Double
                        }
                        VariableType.LONG -> {
                            variableValue =
                                (rawDataMap["value"] as Double).toLong()
                        }
                        VariableType.STRING,
                        VariableType.UNSPECIFIED -> {
                            // should not happen
                        }
                    }
                }
                is Long -> {
                    when (variableType) {
                        VariableType.DOUBLE -> {
                            variableValue =
                                (rawDataMap["value"] as Long).toDouble()
                        }
                        VariableType.LONG -> {
                            variableValue =
                                rawDataMap["value"] as Long
                        }
                        VariableType.STRING,
                        VariableType.UNSPECIFIED -> {
                            // should not happen
                        }
                    }
                }
                is String -> {
                    when (variableType) {
                        VariableType.DOUBLE,
                        VariableType.LONG,
                        VariableType.UNSPECIFIED -> {
                            // do nothing
                        }
                        VariableType.STRING -> {
                            variableValue = rawDataMap["value"]
                        }
                    }
                }
                else -> {
                    // should not happen
                }
            }

            return ExtractedSetVariableData(
                name = variableName,
                variableType = variableType,
                variableValue = variableValue,
                variableDoublePrecision = variableDoublePrecision
            )
        }

        fun extractIncrementVariableData(rawDataMap: Map<String, Any>?): ExtractedIncrementVariableData? {
            if (rawDataMap == null) {
                return null
            }

            var variableName: String? = null
            var variableAmount: Double? = null


            rawDataMap.let { data ->
                data.keys.forEach { key ->
                    val any = data[key]
                    when (key) {
                        "name" -> {
                            any?.let { variableName = it as String }
                        }
                        "amount" -> {
                            any?.let {
                                when (it) {
                                    is Double -> {
                                        variableAmount = it
                                    }
                                    is Long -> {
                                        variableAmount = it.toDouble()
                                    }
                                    else -> {
                                        // should not happen
                                    }
                                }
                            }
                        }
                    }
                }
            }

            if (variableName == null || variableAmount == null) {
                return null
            }
            return ExtractedIncrementVariableData(name = variableName!!, amount = variableAmount!!)
        }

        fun extractMarkTimelineData(rawDataMap: Map<String, Any>?): ExtractedMarkTimelineData? {
            if (rawDataMap == null) {
                return null
            }

            var seekOffset = 0L
            var label: String? = null
            var color: String? = null

            rawDataMap.let { data ->
                data.keys.forEach { key ->
                    val any = data[key]
                    when (key) {

                        "seek_offset" -> {
                            any?.let {
                                when (it) {
                                    is Double -> {
                                        seekOffset = it.toLong()
                                    }
                                    is Long -> {
                                        seekOffset = it
                                    }
                                    else -> {
                                        // do nothing
                                    }
                                }
                            }
                        }
                        "label" -> {
                            any?.let { label = it as String }
                        }

                        "color" -> {
                            any?.let { color = it as String }
                        }
                        else -> {
                            // do nothing
                        }
                    }
                }
            }


            if (label == null || color == null) {
                return null
            }
            return ExtractedMarkTimelineData(
                seekOffset = seekOffset,
                label = label!!,
                color = color!!
            )
        }

        fun extractDeleteActionData(rawDataMap: Map<String, Any>?): String? {
            if (rawDataMap == null) {
                return null
            }
            var targetActionId: String? = null

            rawDataMap.let { data ->
                data.keys.forEach { key ->
                    val any = data[key]
                    when (key) {
                        "action_id" -> {
                            any?.let {
                                targetActionId = it as String
                            }
                        }
                    }
                }
            }

            return targetActionId
        }


        private fun extractSize(
            sizePair: MutablePair<Float, Float>,
            data: Any
        ) {
            val map = data as Map<*, *>

            for (key in map.keys) {
                val value = map[key]
                if (value !is Double) {
                    continue
                }

                when (key) {
                    "width" -> {
                        sizePair.first = (value.toFloat())
                    }
                    "height" -> {
                        sizePair.second = (value.toFloat())
                    }

                    else -> {
                    }
                }

            }
        }

        private fun extractPositionGuide(data: Any): PositionGuide {
            val positionGuide = PositionGuide()
            val map = data as Map<*, *>

            for (key in map.keys) {
                val value = map[key]
                if (value !is Double) {
                    continue
                }

                when (key) {
                    "top" -> {
                        positionGuide.top = (value.toFloat())
                    }
                    "right" -> {
                        positionGuide.right = (value.toFloat())
                    }
                    "bottom" -> {
                        positionGuide.bottom = (value.toFloat())
                    }
                    "left" -> {
                        positionGuide.left = (value.toFloat())
                    }
                    "HCenter" -> {
                        positionGuide.hCenter = (value.toFloat())
                    }
                    "VCenter" -> {
                        positionGuide.vCenter = (value.toFloat())
                    }

                    else -> {
                    }
                }

            }
            return positionGuide
        }

    }
}
