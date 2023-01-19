package tv.mycujoo.annotation.helper

import tv.mycujoo.mclscore.model.AnnotationAction

interface IDownloaderClient {
    fun download(
        showOverlayAction: AnnotationAction.ShowOverlayAction,
        callback: (AnnotationAction.ShowOverlayAction) -> Unit
    )
}