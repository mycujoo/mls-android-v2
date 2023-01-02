package tv.mycujoo.annotationisolation.app

import android.app.Application
import tv.mycujoo.annotationisolation.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import timber.log.Timber
import javax.inject.Inject

class ApplicationClass : Application(), HasAndroidInjector {

    @Inject
    lateinit var androidInjector : DispatchingAndroidInjector<Any>

    override fun onCreate() {
        super.onCreate()
        Timber.plant(Timber.DebugTree())

        DaggerApplicationComponent
            .builder()
            .bindContext(this)
            .create()
            .inject(this)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return androidInjector
    }
}