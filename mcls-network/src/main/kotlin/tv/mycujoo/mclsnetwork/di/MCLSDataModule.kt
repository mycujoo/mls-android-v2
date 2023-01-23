package tv.mycujoo.mclsnetwork.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import tv.mycujoo.mclsnetwork.api.DataManager
import tv.mycujoo.mclsnetwork.data.repository.EventsRepository
import tv.mycujoo.mclsnetwork.data.IDataManager
import tv.mycujoo.mclsnetwork.domain.repository.IEventsRepository
import tv.mycujoo.mclscore.logger.LogLevel
import tv.mycujoo.mclsnetwork.manager.IPrefManager
import tv.mycujoo.mclscore.logger.Logger
import tv.mycujoo.mclsnetwork.manager.PrefManager
import tv.mycujoo.mclsnetwork.network.socket.BFFRTSocket
import tv.mycujoo.mclsnetwork.network.socket.IBFFRTSocket
import tv.mycujoo.mclsnetwork.network.socket.IReactorSocket
import tv.mycujoo.mclsnetwork.network.socket.ReactorSocket
import javax.inject.Singleton

@Module(
    includes = [
        MCLSDataModuleBinds::class,
        MCLSDataModuleProvides::class,
        NetworkModule::class,
    ]
)
interface MCLSDataModule

@Module
class MCLSDataModuleProvides {

    @Provides
    @Singleton
    fun provideLogLevel(): LogLevel = LogLevel.VERBOSE

    @Provides
    @Singleton
    fun provideSharedPreferences(context: Context): SharedPreferences = context
        .getSharedPreferences("MLS", Context.MODE_PRIVATE)

    @OptIn(DelicateCoroutinesApi::class)
    @Provides
    @Singleton
    fun provideGlobalScope(): CoroutineScope = GlobalScope

    @Provides
    @Singleton
    fun provideLogger(): Logger {
        return Logger(LogLevel.VERBOSE)
    }

    @ConcurrencySocketUrl
    @Provides
    @Singleton
    fun provideConcurrencySocketUrl(): String = "wss://bff-rt.mycujoo.tv"

    @ReactorUrl
    @Provides
    @Singleton
    fun provideReactorSocketUrl(): String = "wss://mls-rt.mycujoo.tv"
}

@Module
interface MCLSDataModuleBinds {
    @Binds
    @Singleton
    fun bindDataManager(dateManager: DataManager): IDataManager

    @Binds
    @Singleton
    fun bindPrefManager(prefManager: PrefManager): IPrefManager

    @Binds
    @Singleton
    fun bindRepository(eventRepository: EventsRepository): IEventsRepository

    @Binds
    @Singleton
    fun bindReactorSocket(reactorSocket: ReactorSocket): IReactorSocket

    @Binds
    @Singleton
    fun bindBffRtSocket(bffrtSocket: BFFRTSocket): IBFFRTSocket
}