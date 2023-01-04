package tv.mycujoo.mclsnetwork.data.repository;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import tv.mycujoo.mclsnetwork.network.MlsApi;

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
public final class EventsRepository_Factory implements Factory<EventsRepository> {
  private final Provider<MlsApi> apiProvider;

  public EventsRepository_Factory(Provider<MlsApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public EventsRepository get() {
    return newInstance(apiProvider.get());
  }

  public static EventsRepository_Factory create(Provider<MlsApi> apiProvider) {
    return new EventsRepository_Factory(apiProvider);
  }

  public static EventsRepository newInstance(MlsApi api) {
    return new EventsRepository(api);
  }
}
