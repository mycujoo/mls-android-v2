package tv.mycujoo.mclscompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import tv.mycujoo.mcls.widget.MCLSView

class MCLSCompose(
    private val publicKey: String,
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

                mcls.apply {
                    setPublicKey(publicKey)
                    setConcurrencyEnabled(concurrencyControlEnabled)
                    setImaWithParams(adUnit, liveAdUnit)
                    setupCast()
                }

                this.mcls = mcls
                mcls
            },
        )
    }
}
