package tv.mycujoo.samplemcls.app

import timber.log.Timber
import tv.mycujoo.mclscast.MLSCastOptionsProviderAbstract

class MCLSCastOptionsProvider : MLSCastOptionsProviderAbstract() {
    override fun getCastAppId(): String {
        Timber.d("getCastAppId")
        return "4381F502"
    }
}