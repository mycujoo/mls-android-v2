package tv.mycujoo.mclscompose

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import tv.mycujoo.mcls.widget.MCLSView

class MCLSCompose {

    var mcls: MCLSView? = null

    @Composable
    fun MCLS(modifier: Modifier = Modifier) {
        AndroidView(
            modifier = modifier,
            factory = {
                val mcls = MCLSView(context = it)
                this.mcls = mcls
                mcls
            },
        )
    }
}
