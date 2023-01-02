package tv.mycujoo.annotationisolation.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import tv.mycujoo.annotationisolation.app.MainActivity

@Module
abstract class MainActivityInjectionModule {

    @ContributesAndroidInjector
    abstract fun contributeActivityAndroidInjector(): MainActivity

}