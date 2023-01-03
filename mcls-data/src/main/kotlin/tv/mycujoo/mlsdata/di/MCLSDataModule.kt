package tv.mycujoo.mlsdata.di

import android.content.Context
import android.content.SharedPreferences
import dagger.Binds
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.GlobalScope
import tv.mycujoo.mlsdata.api.DataManager
import tv.mycujoo.mlsdata.data.repository.EventsRepository
import tv.mycujoo.mlsdata.data.IDataManager
import tv.mycujoo.mlsdata.domain.repository.IEventsRepository
import tv.mycujoo.mlsdata.enum.LogLevel
import tv.mycujoo.mlsdata.manager.IPrefManager
import tv.mycujoo.mlsdata.manager.Logger
import tv.mycujoo.mlsdata.manager.PrefManager
import tv.mycujoo.mlsdata.network.socket.BFFRTSocket
import tv.mycujoo.mlsdata.network.socket.IBFFRTSocket
import tv.mycujoo.mlsdata.network.socket.IReactorSocket
import tv.mycujoo.mlsdata.network.socket.ReactorSocket
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