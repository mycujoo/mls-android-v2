package tv.mycujoo.mclsnetwork.domain.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import tv.mycujoo.mclsnetwork.domain.repository.IEventsRepository;

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
public final class GetEventsUseCase_Factory implements Factory<GetEventsUseCase> {
  private final Provider<IEventsRepository> repositoryProvider;

  public GetEventsUseCase_Factory(Provider<IEventsRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetEventsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetEventsUseCase_Factory create(Provider<IEventsRepository> repositoryProvider) {
    return new GetEventsUseCase_Factory(repositoryProvider);
  }

  public static GetEventsUseCase newInstance(IEventsRepository repository) {
    return new GetEventsUseCase(repository);
  }
}
