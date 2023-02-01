package tv.mycujoo.mclscompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import tv.mycujoo.mcls.widget.MCLSView

class MCLSCompose(
    private val publicKey: String,
    private val castAppId: String,
    private val liveAdUnit: String,
    private val adUnit: String,
    private val concurrencyControlEnabled: Boolean = false,
) {

    var mcls: MCLSView? = null

    @Composable
    fun MCLS(modifier: Modifier = Modifier) {
        AndroidView(
            modifier = modifier,
            factory = {
                val mcls = MCLSView(context = it)

                mcls.initialize(
                    publicKey,
                    castAppId,
                    liveAdUnit,
                    adUnit,
                    concurrencyControlEnabled
                )

                this.mcls = mcls
                mcls
            },
        )
    }
}
