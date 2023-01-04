package tv.mycujoo.mclsnetwork.api;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;
import tv.mycujoo.mclsnetwork.domain.usecase.GetActionsUseCase;
import tv.mycujoo.mclsnetwork.domain.usecase.GetEventDetailUseCase;
import tv.mycujoo.mclsnetwork.domain.usecase.GetEventsUseCase;
import tv.mycujoo.mclsnetwork.manager.Logger;

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
public final class DataManager_Factory implements Factory<DataManager> {
  private final Provider<CoroutineScope> scopeProvider;

  private final Provider<Logger> loggerProvider;

  private final Provider<GetEventDetailUseCase> getEventDetailUseCaseProvider;

  private final Provider<GetEventsUseCase> getEventsUseCaseProvider;

  private final Provider<GetActionsUseCase> getActionsUseCaseProvider;

  public DataManager_Factory(Provider<CoroutineScope> scopeProvider,
      Provider<Logger> loggerProvider,
      Provider<GetEventDetailUseCase> getEventDetailUseCaseProvider,
      Provider<GetEventsUseCase> getEventsUseCaseProvider,
      Provider<GetActionsUseCase> getActionsUseCaseProvider) {
    this.scopeProvider = scopeProvider;
    this.loggerProvider = loggerProvider;
    this.getEventDetailUseCaseProvider = getEventDetailUseCaseProvider;
    this.getEventsUseCaseProvider = getEventsUseCaseProvider;
    this.getActionsUseCaseProvider = getActionsUseCaseProvider;
  }

  @Override
  public DataManager get() {
    return newInstance(scopeProvider.get(), loggerProvider.get(), getEventDetailUseCaseProvider.get(), getEventsUseCaseProvider.get(), getActionsUseCaseProvider.get());
  }

  public static DataManager_Factory create(Provider<CoroutineScope> scopeProvider,
      Provider<Logger> loggerProvider,
      Provider<GetEventDetailUseCase> getEventDetailUseCaseProvider,
      Provider<GetEventsUseCase> getEventsUseCaseProvider,
      Provider<GetActionsUseCase> getActionsUseCaseProvider) {
    return new DataManager_Factory(scopeProvider, loggerProvider, getEventDetailUseCaseProvider, getEventsUseCaseProvider, getActionsUseCaseProvider);
  }

  public static DataManager newInstance(CoroutineScope scope, Logger logger,
      GetEventDetailUseCase getEventDetailUseCase, GetEventsUseCase getEventsUseCase,
      GetActionsUseCase getActionsUseCase) {
    return new DataManager(scope, logger, getEventDetailUseCase, getEventsUseCase, getActionsUseCase);
  }
}
