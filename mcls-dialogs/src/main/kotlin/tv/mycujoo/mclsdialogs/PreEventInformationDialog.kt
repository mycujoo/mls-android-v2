package tv.mycujoo.mclsdialogs

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import tv.mycujoo.mclsdialogs.databinding.DialogEventInfoPreEventLayoutBinding

fun inflatePreEventInformationDialog(
    container: ViewGroup,
    title: String = "",
    description: String = "",
    startTime: String = "",
    posterUrl: String? = null,
): ConstraintLayout {
    val inflater = LayoutInflater.from(container.context)
    val viewBindings = DialogEventInfoPreEventLayoutBinding.inflate(inflater, container, true)

    if (posterUrl != null && posterUrl.isNotEmpty()) {
        viewBindings.eventInfoPreEventDialogPosterView.visibility = View.VISIBLE
        viewBindings.preEventInfoDialogTextualLayout.visibility = View.GONE

        Glide.with(viewBindings.eventInfoPreEventDialogPosterView)
            .load(posterUrl)
            .into(viewBindings.eventInfoPreEventDialogPosterView)
    } else {
        viewBindings.preEventInfoDialogTextualLayout.visibility = View.VISIBLE
        viewBindings.eventInfoPreEventDialogPosterView.visibility = View.GONE

        viewBindings.preEventInfoDialogTitleTextView.text = title
        viewBindings.preEventInfoDialogBodyTextView.text = description
        viewBindings.preEventInfoDialogStartTimeTextView.text = startTime
    }

    return viewBindings.root
}