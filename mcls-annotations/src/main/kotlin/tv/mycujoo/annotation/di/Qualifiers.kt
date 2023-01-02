package tv.mycujoo.annotation.di

import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class ApiBaseUrl

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class MLSAPI

@Qualifier
@Retention(AnnotationRetention.RUNTIME)
annotation class CountingIdlingResourceViewIdentifierManager

@Qualifier
@Retention
annotation class TickerFlow