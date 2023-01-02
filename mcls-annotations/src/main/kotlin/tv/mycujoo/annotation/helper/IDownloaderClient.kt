package tv.mycujoo.annotation.helper

import tv.mycujoo.mclscore.model.Action

interface IDownloaderClient {
    fun download(
        showOverlayAction: Action.ShowOverlayAction,
        callback: (Action.ShowOverlayAction) -> Unit
    )
}