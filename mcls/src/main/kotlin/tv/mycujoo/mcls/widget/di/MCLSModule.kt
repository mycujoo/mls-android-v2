package tv.mycujoo.mcls.widget.di

import dagger.Binds
import dagger.Module
import tv.mycujoo.mcls.widget.prefs.IPreferences
import tv.mycujoo.mcls.widget.prefs.Preferences
import javax.inject.Singleton

@Module(
    includes = [
        MCLSModuleProvides::class,
        MCLSModuleBinds::class
    ]
)
interface MCLSModule

@Module
interface MCLSModuleProvides

@Module
interface MCLSModuleBinds {


    @Binds
    @Singleton
    fun bindIPreferences(preferences: Preferences): IPreferences
}