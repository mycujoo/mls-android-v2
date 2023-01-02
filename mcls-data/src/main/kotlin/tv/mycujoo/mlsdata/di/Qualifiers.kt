package tv.mycujoo.mlsdata.di

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