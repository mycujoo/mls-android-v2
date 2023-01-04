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
public final class UuidUtils_Factory implements Factory<UuidUtils> {
  private final Provider<IPrefManager> prefManagerProvider;

  public UuidUtils_Factory(Provider<IPrefManager> prefManagerProvider) {
    this.prefManagerProvider = prefManagerProvider;
  }

  @Override
  public UuidUtils get() {
    return newInstance(prefManagerProvider.get());
  }

  public static UuidUtils_Factory create(Provider<IPrefManager> prefManagerProvider) {
    return new UuidUtils_Factory(prefManagerProvider);
  }

  public static UuidUtils newInstance(IPrefManager prefManager) {
    return new UuidUtils(prefManager);
  }
}
