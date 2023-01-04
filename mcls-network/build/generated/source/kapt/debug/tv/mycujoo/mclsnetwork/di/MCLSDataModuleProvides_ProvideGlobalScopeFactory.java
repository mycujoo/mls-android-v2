package tv.mycujoo.mclsnetwork.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import kotlinx.coroutines.CoroutineScope;

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
public final class MCLSDataModuleProvides_ProvideGlobalScopeFactory implements Factory<CoroutineScope> {
  private final MCLSDataModuleProvides module;

  public MCLSDataModuleProvides_ProvideGlobalScopeFactory(MCLSDataModuleProvides module) {
    this.module = module;
  }

  @Override
  public CoroutineScope get() {
    return provideGlobalScope(module);
  }

  public static MCLSDataModuleProvides_ProvideGlobalScopeFactory create(
      MCLSDataModuleProvides module) {
    return new MCLSDataModuleProvides_ProvideGlobalScopeFactory(module);
  }

  public static CoroutineScope provideGlobalScope(MCLSDataModuleProvides instance) {
    return Preconditions.checkNotNullFromProvides(instance.provideGlobalScope());
  }
}
