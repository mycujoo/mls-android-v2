package tv.mycujoo.mclsnetwork.util;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import tv.mycujoo.mclsnetwork.manager.IPrefManager;

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
public final class UserPreferencesUtils_Factory implements Factory<UserPreferencesUtils> {
  private final Provider<IPrefManager> prefManagerProvider;

  public UserPreferencesUtils_Factory(Provider<IPrefManager> prefManagerProvider) {
    this.prefManagerProvider = prefManagerProvider;
  }

  @Override
  public UserPreferencesUtils get() {
    return newInstance(prefManagerProvider.get());
  }

  public static UserPreferencesUtils_Factory create(Provider<IPrefManager> prefManagerProvider) {
    return new UserPreferencesUtils_Factory(prefManagerProvider);
  }

  public static UserPreferencesUtils newInstance(IPrefManager prefManager) {
    return new UserPreferencesUtils(prefManager);
  }
}
