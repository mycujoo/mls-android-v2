package tv.mycujoo.mclscast

import android.content.Context
import com.google.android.gms.cast.framework.CastOptions
import com.google.android.gms.cast.framework.OptionsProvider
import com.google.android.gms.cast.framework.SessionProvider

abstract class MLSCastOptionsProviderAbstract : OptionsProvider {

    override fun getCastOptions(context: Context): CastOptions {

        return CastOptions.Builder()
            .setReceiverApplicationId(getCastAppId())
            .build()
    }

    override fun getAdditionalSessionProviders(context: Context): MutableList<SessionProvider> {
        return mutableListOf()
    }

    abstract fun getCastAppId(): String
}