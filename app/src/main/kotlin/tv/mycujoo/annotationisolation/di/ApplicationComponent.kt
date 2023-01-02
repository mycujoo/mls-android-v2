package tv.mycujoo.annotationisolation.di

import android.content.Context
import dagger.BindsInstance
import tv.mycujoo.annotationisolation.app.ApplicationClass
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        MainActivityInjectionModule::class,
    ]
)
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder

        fun create(): ApplicationComponent
    }

    fun inject(app: ApplicationClass)
}