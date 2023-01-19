package tv.mycujoo.mclscast.di

import androidx.mediarouter.app.MediaRouteButton
import com.google.android.gms.cast.framework.CastContext
import dagger.BindsInstance
import dagger.Component
import tv.mycujoo.mclscast.MCLSCast
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        MCLSCastModule::class
    ]
)
interface MCLSCastComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun bindMediaRouteButton(mediaRouteButton: MediaRouteButton): Builder

        @BindsInstance
        fun bindAppId(@CastAppId appId: String): Builder

        @BindsInstance
        fun bindCastContext(castContext: CastContext): Builder

        fun build(): MCLSCastComponent
    }

    fun inject(builder: MCLSCast)
}