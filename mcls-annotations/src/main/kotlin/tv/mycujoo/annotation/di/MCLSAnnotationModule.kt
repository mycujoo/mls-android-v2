package tv.mycujoo.annotation.di


import androidx.test.espresso.idling.CountingIdlingResource
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import okhttp3.OkHttpClient
import tv.mycujoo.annotation.core.AnnotationFactory
import tv.mycujoo.annotation.core.AnnotationListener
import tv.mycujoo.annotation.core.IAnnotationFactory
import tv.mycujoo.annotation.core.IAnnotationListener
import tv.mycujoo.annotation.domain.enum.LogLevel
import tv.mycujoo.annotation.helper.*
import tv.mycujoo.annotation.manager.IVariableKeeper
import tv.mycujoo.annotation.manager.Logger
import tv.mycujoo.annotation.manager.VariableKeeper
import tv.mycujoo.annotation.manager.ViewHandler
import tv.mycujoo.annotation.mediator.AnnotationManagerImpl
import tv.mycujoo.annotation.mediator.AnnotationManager
import javax.inject.Singleton

@Module(
    includes = [
        MCLSAnnotationBinds::class,
        MCLSAnnotationProvides::class,
    ]
)
class MCLSAnnotationModule

@OptIn(DelicateCoroutinesApi::class)
@Module
class MCLSAnnotationProvides {

    @Provides
    @Singleton
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient()
    }

    @CountingIdlingResourceViewIdentifierManager
    @Provides
    @Singleton
    fun provideViewIdentifierManagerCountingIdlingResources(): CountingIdlingResource {
        return CountingIdlingResource("ViewIdentifierManager")
    }

    @Provides
    @Singleton
    fun provideScope(): CoroutineScope {
        return GlobalScope
    }

    @Provides
    @Singleton
    fun provideLogger(): Logger {
        return Logger(LogLevel.VERBOSE)
    }
}

@Module
interface MCLSAnnotationBinds {



    @Binds
    @Singleton
    fun bindIDownloadClient(downloaderClient: DownloaderClient): IDownloaderClient

    @Binds
    @Singleton
    fun bindAnnotationListener(annotationListener: AnnotationListener): IAnnotationListener

    @Binds
    @Singleton
    fun bindOverlayFactory(overlayFactory: OverlayFactory): IOverlayFactory

    @Binds
    @Singleton
    fun bindViewHandler(viewHandler: ViewHandler): IViewHandler

    @Binds
    @Singleton
    fun bindVariableKeeper(variableKeeper: VariableKeeper): IVariableKeeper

    @Binds
    @Singleton
    fun bindAnnotationMediator(annotationMediator: AnnotationManagerImpl): AnnotationManager

    @Binds
    @Singleton
    fun bindIAnnotationFactory(annotationFactory: AnnotationFactory): IAnnotationFactory
}
