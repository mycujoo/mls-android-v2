package tv.mycujoo.samplemcls

import android.app.Application
import timber.log.Timber

class ApplicationClass : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())
    }
}