package tv.mycujoo.mclsnetwork.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tv.mycujoo.mclsnetwork.MCLSNetwork
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MCLSDataModule::class
    ]
)
interface MCLSDataComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindContext(context: Context): Builder

        fun create(): MCLSDataComponent
    }

    fun inject(mclsNetwork: MCLSNetwork.Builder)
}