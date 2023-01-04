package tv.mycujoo.mclsnetwork.manager;

import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class PrefManager_Factory implements Factory<PrefManager> {
  private final Provider<SharedPreferences> sharedPreferencesProvider;

  public PrefManager_Factory(Provider<SharedPreferences> sharedPreferencesProvider) {
    this.sharedPreferencesProvider = sharedPreferencesProvider;
  }

  @Override
  public PrefManager get() {
    return newInstance(sharedPreferencesProvider.get());
  }

  public static PrefManager_Factory create(Provider<SharedPreferences> sharedPreferencesProvider) {
    return new PrefManager_Factory(sharedPreferencesProvider);
  }

  public static PrefManager newInstance(SharedPreferences sharedPreferences) {
    return new PrefManager(sharedPreferences);
  }
}
