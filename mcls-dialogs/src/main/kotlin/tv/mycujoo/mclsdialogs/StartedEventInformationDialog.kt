package tv.mycujoo.mclsdialogs

import android.view.LayoutInflater
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import tv.mycujoo.mclsdialogs.databinding.DialogEventInfoStartedLayoutBinding

fun inflateStartedEventInformationDialog(
    parent: FrameLayout,
    title: String = "",
    description: String = "",
    startTime: String = "",
): ConstraintLayout {
    val dialog = DialogEventInfoStartedLayoutBinding.inflate(
        LayoutInflater.from(parent.context),
        parent,
        true
    )

    dialog.startedEventInfoDialogTitleTextView.text = title
    dialog.startedEventInfoDialogBodyTextView.text = description
    dialog.startedEventInfoDialogStartTimeTextView.text = startTime

    return dialog.root
}