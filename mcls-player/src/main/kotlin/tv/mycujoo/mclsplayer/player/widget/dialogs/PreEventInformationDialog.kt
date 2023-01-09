package tv.mycujoo.mclsplayer.player.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import com.bumptech.glide.Glide
import tv.mycujoo.mclsplayer.databinding.DialogEventInfoPreEventLayoutBinding
import tv.mycujoo.mclsplayer.player.model.UiEvent

fun inflatePreEventInformationDialog(
    container: ViewGroup,
    uiEvent: UiEvent
): ConstraintLayout {
    val inflater = LayoutInflater.from(container.context)
    val viewBindings = DialogEventInfoPreEventLayoutBinding.inflate(inflater, container, true)

    if (uiEvent.posterUrl != null && uiEvent.posterUrl.isNotEmpty()) {
        viewBindings.eventInfoPreEventDialogPosterView.visibility = View.VISIBLE
        viewBindings.preEventInfoDialogTextualLayout.visibility = View.GONE

        Glide.with(viewBindings.eventInfoPreEventDialogPosterView)
            .load(uiEvent.posterUrl)
            .into(viewBindings.eventInfoPreEventDialogPosterView)
    } else {
        viewBindings.preEventInfoDialogTextualLayout.visibility = View.VISIBLE
        viewBindings.eventInfoPreEventDialogPosterView.visibility = View.GONE

        viewBindings.preEventInfoDialogTitleTextView.text = uiEvent.title ?: ""
        viewBindings.preEventInfoDialogBodyTextView.text = uiEvent.description ?: ""
        viewBindings.preEventInfoDialogStartTimeTextView.text = uiEvent.startTime
    }

    return viewBindings.root
}