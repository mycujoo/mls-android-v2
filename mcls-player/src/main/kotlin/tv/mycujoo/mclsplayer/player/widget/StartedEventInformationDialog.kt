package tv.mycujoo.mclsplayer.player.widget

import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import tv.mycujoo.mclsplayer.databinding.DialogEventInfoStartedLayoutBinding
import tv.mycujoo.mclsplayer.player.model.UiEvent

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