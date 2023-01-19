package tv.mycujoo.mclsnetwork.domain.entity

import com.squareup.moshi.Json
import tv.mycujoo.mclscore.model.AnnotationAction
import tv.mycujoo.mclscore.model.SvgData
import tv.mycujoo.mclscore.model.TransitionSpec
import tv.mycujoo.mclscore.model.ViewSpec
import tv.mycujoo.mclsnetwork.domain.mapper.DataMapper
import tv.mycujoo.mclsnetwork.domain.model.ActionType
import tv.mycujoo.mclsnetwork.domain.model.ActionType.*
import java.util.*

data class ActionSourceData(
    @field:Json(name = "id") val id: String?,
    @field:Json(name = "type") val type: String?,
    @field:Json(name = "offset") val offset: Long?,
    @field:Json(name = "absoluteTime") val absoluteTime: Long?,
    @field:Json(name = "data") val data: Map<String, Any>?
) {
    fun toAction(): AnnotationAction {
        val newId = id.orEmpty()
        val newType = ActionType.fromValueOrUnknown(this.type.orEmpty())
        var newOffset: Long = -1L
        offset?.let { newOffset = it }
        var newAbsoluteTime: Long = -1L
        absoluteTime?.let { newAbsoluteTime = it }


        when (newType) {
            SHOW_OVERLAY -> {
                val relatedData = DataMapper.extractShowOverlayRelatedData(data)
                if (relatedData != null) {

                    var outroTransitionSpec: TransitionSpec? = null
                    if (relatedData.duration != null) {
                        outroTransitionSpec = TransitionSpec(
                            newOffset + relatedData.duration,
                            relatedData.outroAnimationType,
                            relatedData.outroAnimationDuration
                        )
                    }
                    return AnnotationAction.ShowOverlayAction(
                        id = newId,
                        offset = newOffset,
                        absoluteTime = newAbsoluteTime,
                        duration = relatedData.duration,
                        viewSpec = ViewSpec(
                            relatedData.positionGuide,
                            relatedData.sizePair
                        ),
                        svgData = SvgData(relatedData.svgUrl),
                        introTransitionSpec = TransitionSpec(
                            newOffset,
                            relatedData.introAnimationType,
                            relatedData.introAnimationDuration
                        ),
                        outroTransitionSpec = outroTransitionSpec,
                        placeHolders = relatedData.variablePlaceHolders,
                        customId = relatedData.customId ?: UUID.randomUUID().toString()
                    )
                }
            }
            HIDE_OVERLAY -> {
                val relatedData = DataMapper.extractHideOverlayRelatedData(data)
                if (relatedData != null) {
                    return AnnotationAction.HideOverlayAction(
                        id = newId,
                        offset = newOffset,
                        absoluteTime = newAbsoluteTime,
                        outroTransitionSpec = TransitionSpec(
                            newOffset,
                            relatedData.outroAnimationType,
                            relatedData.outroAnimationDuration
                        ),
                        customId = relatedData.id
                    )

                }
            }

            RESHOW_OVERLAY -> {
                val customId = DataMapper.extractReshowOverlayRelatedData(data)
                if (customId != null) {
                    return AnnotationAction.ReshowOverlayAction(
                        id = newId,
                        offset = newOffset,
                        absoluteTime = newAbsoluteTime,
                        customId = customId
                    )
                }
            }

            CREATE_TIMER -> {
                val relatedData = DataMapper.extractTimerRelatedData(data)
                if (relatedData != null) {
                    return AnnotationAction.CreateTimerAction(
                        id = newId,
                        offset = newOffset,
                        absoluteTime = newAbsoluteTime,
                        name = relatedData.name,
                        format = relatedData.format,
                        direction = relatedData.direction,
                        startValue = relatedData.startValue,
                        capValue = relatedData.capValue
                    )
                }
            }
            START_TIMER -> {
                val relatedData = DataMapper.extractTimerRelatedData(data)
                if (relatedData != null) {
                    return AnnotationAction.StartTimerAction(
                        id = newId,
                        offset = newOffset,
                        absoluteTime = newAbsoluteTime,
                        name = relatedData.name
                    )
                }
            }
            PAUSE_TIMER -> {
                val relatedData = DataMapper.extractTimerRelatedData(data)
                if (relatedData != null) {
                    return AnnotationAction.PauseTimerAction(
                        id = newId,
                        offset = newOffset,
                        absoluteTime = newAbsoluteTime,
                        name = relatedData.name
                    )
                }
            }
            ADJUST_TIMER -> {
                val relatedData = DataMapper.extractTimerRelatedData(data)
                if (relatedData != null) {
                    return AnnotationAction.AdjustTimerAction(
                        id = newId,
                        offset = newOffset,
                        absoluteTime = newAbsoluteTime,
                        name = relatedData.name,
                        value = relatedData.value
                    )

                }
            }
            SKIP_TIMER -> {
                val relatedData = DataMapper.extractTimerRelatedData(data)
                if (relatedData != null) {
                    return AnnotationAction.SkipTimerAction(
                        id = newId,
                        offset = newOffset,
                        absoluteTime = newAbsoluteTime,
                        name = relatedData.name,
                        value = relatedData.value
                    )
                }
            }

            SET_VARIABLE -> {
                val variable = DataMapper.mapToVariable(data)
                return AnnotationAction.CreateVariableAction(
                    id = newId,
                    offset = newOffset,
                    absoluteTime = newAbsoluteTime,
                    variable = variable
                )

            }
            INCREMENT_VARIABLE -> {
                val extractedIncrementVariableData = DataMapper.extractIncrementVariableData(data)
                if (extractedIncrementVariableData != null) {
                    return AnnotationAction.IncrementVariableAction(
                        id = newId,
                        offset = newOffset,
                        absoluteTime = newAbsoluteTime,
                        name = extractedIncrementVariableData.name,
                        amount = extractedIncrementVariableData.amount
                    )
                }
            }

            SHOW_TIMELINE_MARKER -> {
                val extractedMarkTimelineData = DataMapper.extractMarkTimelineData(data)
                if (extractedMarkTimelineData != null) {
                    return AnnotationAction.MarkTimelineAction(
                        id = newId,
                        offset = newOffset,
                        absoluteTime = newAbsoluteTime,
                        seekOffset = extractedMarkTimelineData.seekOffset,
                        label = extractedMarkTimelineData.label,
                        color = extractedMarkTimelineData.color
                    )
                }
            }

            DELETE_ACTION -> {
                val extractedDeleteActionData = DataMapper.extractDeleteActionData(data)
                if (extractedDeleteActionData != null) {
                    return AnnotationAction.DeleteAction(
                        id = newId,
                        offset = newOffset,
                        absoluteTime = newAbsoluteTime,
                        targetActionId = extractedDeleteActionData
                    )
                }
            }
            UNKNOWN -> {
                // do nothing, returns InvalidAction
            }
        }
        return AnnotationAction.InvalidAction(
            newId,
            newOffset,
            newAbsoluteTime
        )
    }
}