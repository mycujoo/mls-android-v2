package tv.mycujoo.mclsui


import androidx.test.espresso.idling.CountingIdlingResource
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.OkHttpClient
import tv.mycujoo.annotation.core.AnnotationFactory
import tv.mycujoo.annotation.core.AnnotationListener
import tv.mycujoo.annotation.core.IAnnotationFactory
import tv.mycujoo.annotation.core.IAnnotationListener
import tv.mycujoo.annotation.di.CountingIdlingResourceViewIdentifierManager
import tv.mycujoo.annotation.di.TickerFlow
import tv.mycujoo.annotation.domain.enum.LogLevel
import tv.mycujoo.annotation.helper.*
import tv.mycujoo.annotation.manager.IVariableKeeper
import tv.mycujoo.annotation.manager.Logger
import tv.mycujoo.annotation.manager.VariableKeeper
import tv.mycujoo.annotation.manager.ViewHandler
import tv.mycujoo.annotation.mediator.AnnotationMediator
import tv.mycujoo.annotation.mediator.IAnnotationMediator
import javax.inject.Singleton

@Module(
    includes = [
        MlsModuleBinds::class,
        MlsModuleProvides::class,
    ]
)
class MlsUiModule

@OptIn(DelicateCoroutinesApi::class)
@Module
class MlsModuleProvides {

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

    @TickerFlow
    @Provides
    @Singleton
    fun provideTickerFlow(): MutableSharedFlow<Long> {
        return MutableStateFlow(1)
    }
}

@Module
interface MlsModuleBinds {



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
    fun bindAnnotationMediator(annotationMediator: AnnotationMediator): IAnnotationMediator

    @Binds
    @Singleton
    fun bindIAnnotationFactory(annotationFactory: AnnotationFactory): IAnnotationFactory
}
