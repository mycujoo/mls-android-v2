package tv.mycujoo.mclscast

import android.content.Context
import com.google.android.gms.cast.framework.CastOptions
import com.google.android.gms.cast.framework.OptionsProvider
import com.google.android.gms.cast.framework.SessionProvider

open class MLSCastOptionsProvider : OptionsProvider {

    lateinit var context: Context

    override fun getCastOptions(context: Context): CastOptions {
        this.context = context

        return CastOptions.Builder()
            .setReceiverApplicationId(getCastAppId())
            .build()
    }

    override fun getAdditionalSessionProviders(context: Context): MutableList<SessionProvider> {
        return mutableListOf()
    }

    open fun getCastAppId(): String {
        return context.getString(R.string.app_cast_id)
    }
}