package tv.mycujoo.mclsnetwork.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("tv.mycujoo.mlsdata.di.ConcurrencySocketUrl")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MCLSDataModuleProvides_ProvideConcurrencySocketUrlFactory implements Factory<String> {
  private final MCLSDataModuleProvides module;

  public MCLSDataModuleProvides_ProvideConcurrencySocketUrlFactory(MCLSDataModuleProvides module) {
    this.module = module;
  }

  @Override
  public String get() {
    return provideConcurrencySocketUrl(module);
  }

  public static MCLSDataModuleProvides_ProvideConcurrencySocketUrlFactory create(
      MCLSDataModuleProvides module) {
    return new MCLSDataModuleProvides_ProvideConcurrencySocketUrlFactory(module);
  }

  public static String provideConcurrencySocketUrl(MCLSDataModuleProvides instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideConcurrencySocketUrl());
  }
}
