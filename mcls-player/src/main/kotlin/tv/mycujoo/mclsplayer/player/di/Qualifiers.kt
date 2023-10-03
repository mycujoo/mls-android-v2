package tv.mycujoo.mclsplayer.player.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class YouboraAccountCode

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PublicKey

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class IdentityToken