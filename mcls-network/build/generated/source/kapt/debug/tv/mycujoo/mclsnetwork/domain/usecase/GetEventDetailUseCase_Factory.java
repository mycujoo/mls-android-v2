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
public final class GetEventDetailUseCase_Factory implements Factory<GetEventDetailUseCase> {
  private final Provider<IEventsRepository> repositoryProvider;

  public GetEventDetailUseCase_Factory(Provider<IEventsRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetEventDetailUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetEventDetailUseCase_Factory create(
      Provider<IEventsRepository> repositoryProvider) {
    return new GetEventDetailUseCase_Factory(repositoryProvider);
  }

  public static GetEventDetailUseCase newInstance(IEventsRepository repository) {
    return new GetEventDetailUseCase(repository);
  }
}
