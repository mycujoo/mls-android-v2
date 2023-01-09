package tv.mycujoo.mclsplayer.player.widget

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.widget.FrameLayout
import timber.log.Timber
import tv.mycujoo.mclsplayer.databinding.DialogEventInfoStartedLayoutBinding
import tv.mycujoo.mclsplayer.player.model.UiEvent

@SuppressLint("ViewConstructor")
class StartedEventInformationDialog(
    parent: FrameLayout,
    uiEvent: UiEvent,
    onClick: () -> Unit
) : FrameLayout(parent.context, null) {

    init {
        val dialog = DialogEventInfoStartedLayoutBinding.inflate(
            LayoutInflater.from(context),
            parent,
            true
        )

        dialog.startedEventInfoDialogTitleTextView.text = uiEvent.title ?: ""
        dialog.startedEventInfoDialogBodyTextView.text =
            uiEvent.description ?: ""
        dialog.startedEventInfoDialogStartTimeTextView.text = uiEvent.startTime

        dialog.startedEventInfoDialogTitleTextView.setOnClickListener {
            Timber.tag("MCLSPlayer").d("Click")
            onClick()
        }
    }
}