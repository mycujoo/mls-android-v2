package tv.mycujoo.mclsdialogs

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.constraintlayout.widget.ConstraintLayout
import tv.mycujoo.mclsdialogs.databinding.DialogEventInfoPreEventLayoutBinding

fun inflateCustomInformationDialog(
    container: ViewGroup,
    title: String = "",
    message: String
): ConstraintLayout {
    val inflater = LayoutInflater.from(container.context)
    val binding = DialogEventInfoPreEventLayoutBinding.inflate(inflater, container, true)

    binding.preEventInfoDialogTextualLayout.visibility = FrameLayout.VISIBLE
    binding.eventInfoPreEventDialogPosterView.visibility = FrameLayout.GONE

    binding.preEventInfoDialogTitleTextView.text = title
    binding.preEventInfoDialogBodyTextView.text = message
    binding.preEventInfoDialogBodyTextView.setTextColor(Color.RED)
    binding.preEventInfoDialogStartTimeTextView.visibility = FrameLayout.GONE

    return binding.root
}