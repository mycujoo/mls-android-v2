package tv.mycujoo.mlsdata.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tv.mycujoo.mlsdata.MCLSData
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

    fun inject(mclsData: MCLSData.Builder)
}