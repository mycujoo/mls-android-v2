package tv.mycujoo.mclsnetwork.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import tv.mycujoo.mclsnetwork.manager.Logger;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class MCLSDataModuleProvides_ProvideLoggerFactory implements Factory<Logger> {
  private final MCLSDataModuleProvides module;

  public MCLSDataModuleProvides_ProvideLoggerFactory(MCLSDataModuleProvides module) {
    this.module = module;
  }

  @Override
  public Logger get() {
    return provideLogger(module);
  }

  public static MCLSDataModuleProvides_ProvideLoggerFactory create(MCLSDataModuleProvides module) {
    return new MCLSDataModuleProvides_ProvideLoggerFactory(module);
  }

  public static Logger provideLogger(MCLSDataModuleProvides instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideLogger());
  }
}
