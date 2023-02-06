package tv.mycujoo.mcls.widget.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tv.mycujoo.mcls.widget.MCLSView
import javax.inject.Singleton

@Component(
    modules = [
        MCLSModule::class
    ]
)
@Singleton
interface MCLSComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder

        fun build(): MCLSComponent
    }

    fun inject(mclsView: MCLSView)
}