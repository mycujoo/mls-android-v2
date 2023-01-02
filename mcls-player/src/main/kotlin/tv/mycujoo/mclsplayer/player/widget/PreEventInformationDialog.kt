package tv.mycujoo.mclsplayer.player.widget

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import com.bumptech.glide.Glide
import tv.mycujoo.mclsplayer.player.model.UiEvent
import tv.mycujoo.mclsplayer.databinding.DialogEventInfoPreEventLayoutBinding

@SuppressLint("ViewConstructor")
class PreEventInformationDialog(container: ViewGroup, uiEvent: UiEvent) :
    FrameLayout(container.context, null) {

    init {
        val inflater = LayoutInflater.from(container.context)
        val viewBindings = DialogEventInfoPreEventLayoutBinding.inflate(inflater, container, true)

        if (uiEvent.posterUrl != null && uiEvent.posterUrl.isNotEmpty()) {
            viewBindings.eventInfoPreEventDialogPosterView.visibility = View.VISIBLE
            viewBindings.preEventInfoDialogTextualLayout.visibility = View.GONE

            Glide.with(viewBindings.eventInfoPreEventDialogPosterView)
                .load(uiEvent.posterUrl)
                .into(viewBindings.eventInfoPreEventDialogPosterView as ImageView)
        } else {
            viewBindings.preEventInfoDialogTextualLayout.visibility = View.VISIBLE
            viewBindings.eventInfoPreEventDialogPosterView.visibility = View.GONE

            viewBindings.preEventInfoDialogTitleTextView.text = uiEvent.title ?: ""
            viewBindings.preEventInfoDialogBodyTextView.text = uiEvent.description ?: ""
            viewBindings.preEventInfoDialogStartTimeTextView.text = uiEvent.startTime
        }
    }
}