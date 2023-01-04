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
public final class GetActionsUseCase_Factory implements Factory<GetActionsUseCase> {
  private final Provider<IEventsRepository> repositoryProvider;

  public GetActionsUseCase_Factory(Provider<IEventsRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public GetActionsUseCase get() {
    return newInstance(repositoryProvider.get());
  }

  public static GetActionsUseCase_Factory create(Provider<IEventsRepository> repositoryProvider) {
    return new GetActionsUseCase_Factory(repositoryProvider);
  }

  public static GetActionsUseCase newInstance(IEventsRepository repository) {
    return new GetActionsUseCase(repository);
  }
}
