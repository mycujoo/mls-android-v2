package tv.mycujoo.mclsnetwork.di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class MCLSDataModuleProvides_ProvideSharedPreferencesFactory implements Factory<SharedPreferences> {
  private final MCLSDataModuleProvides module;

  private final Provider<Context> contextProvider;

  public MCLSDataModuleProvides_ProvideSharedPreferencesFactory(MCLSDataModuleProvides module,
      Provider<Context> contextProvider) {
    this.module = module;
    this.contextProvider = contextProvider;
  }

  @Override
  public SharedPreferences get() {
    return provideSharedPreferences(module, contextProvider.get());
  }

  public static MCLSDataModuleProvides_ProvideSharedPreferencesFactory create(
      MCLSDataModuleProvides module, Provider<Context> contextProvider) {
    return new MCLSDataModuleProvides_ProvideSharedPreferencesFactory(module, contextProvider);
  }

  public static SharedPreferences provideSharedPreferences(MCLSDataModuleProvides instance,
      Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideSharedPreferences(context));
  }
}
