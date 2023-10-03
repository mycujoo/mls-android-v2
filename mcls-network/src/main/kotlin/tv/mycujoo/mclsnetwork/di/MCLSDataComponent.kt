package tv.mycujoo.mclsnetwork.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import tv.mycujoo.mclsnetwork.MCLSNetwork
import tv.mycujoo.mclsnetwork.util.KeyStore
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

        @BindsInstance
        fun bindPublicKey(@PublicKey publicKey: KeyStore): Builder

        @BindsInstance
        fun bindIdentityToken(@IdentityToken identityToken: KeyStore): Builder

        fun create(): MCLSDataComponent
    }

    fun inject(mclsNetwork: MCLSNetwork.Builder)
}