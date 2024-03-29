package tv.mycujoo.mclsnetwork.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApiBaseUrl

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MLSAPI

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PublicBaseUrl

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ConcurrencySocketUrl

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ReactorUrl

@Qualifier
@Retention
annotation class CDARetrofit

@Qualifier
@Retention
annotation class CDAUrl

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class PublicKey

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class IdentityToken
