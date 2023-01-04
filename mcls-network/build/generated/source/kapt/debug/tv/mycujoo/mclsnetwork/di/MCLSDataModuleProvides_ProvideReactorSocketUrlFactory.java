package tv.mycujoo.mclsnetwork.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("tv.mycujoo.mlsdata.di.ReactorUrl")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MCLSDataModuleProvides_ProvideReactorSocketUrlFactory implements Factory<String> {
  private final MCLSDataModuleProvides module;

  public MCLSDataModuleProvides_ProvideReactorSocketUrlFactory(MCLSDataModuleProvides module) {
    this.module = module;
  }

  @Override
  public String get() {
    return provideReactorSocketUrl(module);
  }

  public static MCLSDataModuleProvides_ProvideReactorSocketUrlFactory create(
      MCLSDataModuleProvides module) {
    return new MCLSDataModuleProvides_ProvideReactorSocketUrlFactory(module);
  }

  public static String provideReactorSocketUrl(MCLSDataModuleProvides instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideReactorSocketUrl());
  }
}
