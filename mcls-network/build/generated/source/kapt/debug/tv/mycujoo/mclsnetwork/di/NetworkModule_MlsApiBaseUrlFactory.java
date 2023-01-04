package tv.mycujoo.mclsnetwork.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("tv.mycujoo.mlsdata.di.ApiBaseUrl")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_MlsApiBaseUrlFactory implements Factory<String> {
  private final NetworkModule module;

  public NetworkModule_MlsApiBaseUrlFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return mlsApiBaseUrl(module);
  }

  public static NetworkModule_MlsApiBaseUrlFactory create(NetworkModule module) {
    return new NetworkModule_MlsApiBaseUrlFactory(module);
  }

  public static String mlsApiBaseUrl(NetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.mlsApiBaseUrl());
  }
}
