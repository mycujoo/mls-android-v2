package tv.mycujoo.mclsnetwork.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("tv.mycujoo.mlsdata.di.PublicBaseUrl")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_PublicBaseUrlFactory implements Factory<String> {
  private final NetworkModule module;

  public NetworkModule_PublicBaseUrlFactory(NetworkModule module) {
    this.module = module;
  }

  @Override
  public String get() {
    return publicBaseUrl(module);
  }

  public static NetworkModule_PublicBaseUrlFactory create(NetworkModule module) {
    return new NetworkModule_PublicBaseUrlFactory(module);
  }

  public static String publicBaseUrl(NetworkModule instance) {
    return Preconditions.checkNotNullFromProvides(instance.publicBaseUrl());
  }
}
