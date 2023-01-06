package tv.mycujoo.samplemcls.app

import android.app.Application
import dagger.android.DispatchingAndroidInjector
import timber.log.Timber
import javax.inject.Inject

class ApplicationClass : Application() {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())
    }
}