package tv.mycujoo.mclsplayercore.dialog

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import tv.mycujoo.mclsplayercore.databinding.DialogEventInfoPreEventLayoutBinding
import tv.mycujoo.mclsplayercore.model.UiEvent

fun inflateCustomInformationDialog(
    container: ViewGroup,
    uiEvent: UiEvent,
    message: String
): ConstraintLayout {
    val inflater = LayoutInflater.from(container.context)
    val binding = DialogEventInfoPreEventLayoutBinding.inflate(inflater, container, true)

    binding.preEventInfoDialogTextualLayout.visibility = FrameLayout.VISIBLE
    binding.eventInfoPreEventDialogPosterView.visibility = FrameLayout.GONE

    binding.preEventInfoDialogTitleTextView.text = uiEvent.title ?: ""
    binding.preEventInfoDialogBodyTextView.text = message
    binding.preEventInfoDialogBodyTextView.setTextColor(Color.RED)
    binding.preEventInfoDialogStartTimeTextView.visibility = FrameLayout.GONE

    return binding.root
}