package tv.mycujoo.mclsplayercore.dialog

import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import tv.mycujoo.mclsplayercore.databinding.DialogEventInfoStartedLayoutBinding
import tv.mycujoo.mclsplayercore.model.UiEvent

fun inflateStartedEventInformationDialog(
    parent: FrameLayout,
    uiEvent: UiEvent,
): ConstraintLayout {
    val dialog = DialogEventInfoStartedLayoutBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        true
    )

    dialog.startedEventInfoDialogTitleTextView.text = uiEvent.title ?: ""
    dialog.startedEventInfoDialogBodyTextView.text =
        uiEvent.description ?: ""
    dialog.startedEventInfoDialogStartTimeTextView.text = uiEvent.startTime

    return dialog.root
}