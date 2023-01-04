package tv.mycujoo.mclsnetwork.di;

import android.content.Context;
import android.content.SharedPreferences;
import dagger.internal.DaggerGenerated;
import dagger.internal.DoubleCheck;
import dagger.internal.InstanceFactory;
import dagger.internal.Preconditions;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import tv.mycujoo.mclsnetwork.MCLSData_Builder_MembersInjector;
import tv.mycujoo.mclsnetwork.api.DataManager;
import tv.mycujoo.mclsnetwork.api.DataManager_Factory;
import tv.mycujoo.mclsnetwork.data.IDataManager;
import tv.mycujoo.mclsnetwork.data.repository.EventsRepository;
import tv.mycujoo.mclsnetwork.data.repository.EventsRepository_Factory;
import tv.mycujoo.mclsnetwork.domain.repository.IEventsRepository;
import tv.mycujoo.mclsnetwork.domain.usecase.GetActionsUseCase;
import tv.mycujoo.mclsnetwork.domain.usecase.GetActionsUseCase_Factory;
import tv.mycujoo.mclsnetwork.domain.usecase.GetEventDetailUseCase;
import tv.mycujoo.mclsnetwork.domain.usecase.GetEventDetailUseCase_Factory;
import tv.mycujoo.mclsnetwork.domain.usecase.GetEventsUseCase;
import tv.mycujoo.mclsnetwork.domain.usecase.GetEventsUseCase_Factory;
import tv.mycujoo.mclsnetwork.manager.IPrefManager;
import tv.mycujoo.mclsnetwork.manager.Logger;
import tv.mycujoo.mclsnetwork.manager.PrefManager;
import tv.mycujoo.mclsnetwork.manager.PrefManager_Factory;
import tv.mycujoo.mclsnetwork.network.MlsApi;
import tv.mycujoo.mclsnetwork.network.socket.BFFRTSocket;
import tv.mycujoo.mclsnetwork.network.socket.BFFRTSocket_Factory;
import tv.mycujoo.mclsnetwork.network.socket.IReactorSocket;
import tv.mycujoo.mclsnetwork.network.socket.MainWebSocketListener_Factory;
import tv.mycujoo.mclsnetwork.network.socket.ReactorSocket;
import tv.mycujoo.mclsnetwork.network.socket.ReactorSocket_Factory;
import tv.mycujoo.mclsnetwork.util.UserPreferencesUtils;
import tv.mycujoo.mclsnetwork.util.UserPreferencesUtils_Factory;
import tv.mycujoo.mclsnetwork.util.UuidUtils;
import tv.mycujoo.mclsnetwork.util.UuidUtils_Factory;

@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DaggerMCLSDataComponent {
  private DaggerMCLSDataComponent() {
  }

  public static MCLSDataComponent.Builder builder() {
    return new Builder();
  }

  private static final class Builder implements MCLSDataComponent.Builder {
    private Context bindContext;

    @Override
    public Builder bindContext(Context context) {
      this.bindContext = Preconditions.checkNotNull(context);
      return this;
    }

    @Override
    public MCLSDataComponent create() {
      Preconditions.checkBuilderRequirement(bindContext, Context.class);
      return new MCLSDataComponentImpl(new MCLSDataModuleProvides(), new NetworkModule(), bindContext);
    }
  }

  private static final class MCLSDataComponentImpl implements MCLSDataComponent {
    private final MCLSDataComponentImpl mCLSDataComponentImpl = this;

    private Provider<Context> bindContextProvider;

    private Provider<SharedPreferences> provideSharedPreferencesProvider;

    private Provider<PrefManager> prefManagerProvider;

    private Provider<IPrefManager> bindPrefManagerProvider;

    private Provider<Logger> provideLoggerProvider;

    private Provider<CoroutineScope> provideGlobalScopeProvider;

    private Provider<OkHttpClient> provideOkHttpProvider;

    private Provider<String> mlsApiBaseUrlProvider;

    private Provider<Retrofit> provideMlsApiRetrofitProvider;

    private Provider<MlsApi> provideMlsApiProvider;

    private Provider<EventsRepository> eventsRepositoryProvider;

    private Provider<IEventsRepository> bindRepositoryProvider;

    private Provider<GetEventDetailUseCase> getEventDetailUseCaseProvider;

    private Provider<GetEventsUseCase> getEventsUseCaseProvider;

    private Provider<GetActionsUseCase> getActionsUseCaseProvider;

    private Provider<DataManager> dataManagerProvider;

    private Provider<IDataManager> bindDataManagerProvider;

    private Provider<UuidUtils> uuidUtilsProvider;

    private Provider<String> provideReactorSocketUrlProvider;

    private Provider<ReactorSocket> reactorSocketProvider;

    private Provider<IReactorSocket> bindReactorSocketProvider;

    private Provider<UserPreferencesUtils> userPreferencesUtilsProvider;

    private Provider<String> provideConcurrencySocketUrlProvider;

    private Provider<BFFRTSocket> bFFRTSocketProvider;

    private MCLSDataComponentImpl(MCLSDataModuleProvides mCLSDataModuleProvidesParam,
        NetworkModule networkModuleParam, Context bindContextParam) {

      initialize(mCLSDataModuleProvidesParam, networkModuleParam, bindContextParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final MCLSDataModuleProvides mCLSDataModuleProvidesParam,
        final NetworkModule networkModuleParam, final Context bindContextParam) {
      this.bindContextProvider = InstanceFactory.create(bindContextParam);
      this.provideSharedPreferencesProvider = DoubleCheck.provider(MCLSDataModuleProvides_ProvideSharedPreferencesFactory.create(mCLSDataModuleProvidesParam, bindContextProvider));
      this.prefManagerProvider = PrefManager_Factory.create(provideSharedPreferencesProvider);
      this.bindPrefManagerProvider = DoubleCheck.provider((Provider) prefManagerProvider);
      this.provideLoggerProvider = DoubleCheck.provider(MCLSDataModuleProvides_ProvideLoggerFactory.create(mCLSDataModuleProvidesParam));
      this.provideGlobalScopeProvider = DoubleCheck.provider(MCLSDataModuleProvides_ProvideGlobalScopeFactory.create(mCLSDataModuleProvidesParam));
      this.provideOkHttpProvider = DoubleCheck.provider(NetworkModule_ProvideOkHttpFactory.create(networkModuleParam, bindPrefManagerProvider, bindContextProvider));
      this.mlsApiBaseUrlProvider = DoubleCheck.provider(NetworkModule_MlsApiBaseUrlFactory.create(networkModuleParam));
      this.provideMlsApiRetrofitProvider = DoubleCheck.provider(NetworkModule_ProvideMlsApiRetrofitFactory.create(networkModuleParam, provideOkHttpProvider, mlsApiBaseUrlProvider));
      this.provideMlsApiProvider = DoubleCheck.provider(NetworkModule_ProvideMlsApiFactory.create(networkModuleParam, provideMlsApiRetrofitProvider));
      this.eventsRepositoryProvider = EventsRepository_Factory.create(provideMlsApiProvider);
      this.bindRepositoryProvider = DoubleCheck.provider((Provider) eventsRepositoryProvider);
      this.getEventDetailUseCaseProvider = GetEventDetailUseCase_Factory.create(bindRepositoryProvider);
      this.getEventsUseCaseProvider = GetEventsUseCase_Factory.create(bindRepositoryProvider);
      this.getActionsUseCaseProvider = GetActionsUseCase_Factory.create(bindRepositoryProvider);
      this.dataManagerProvider = DataManager_Factory.create(provideGlobalScopeProvider, provideLoggerProvider, getEventDetailUseCaseProvider, getEventsUseCaseProvider, getActionsUseCaseProvider);
      this.bindDataManagerProvider = DoubleCheck.provider((Provider) dataManagerProvider);
      this.uuidUtilsProvider = UuidUtils_Factory.create(bindPrefManagerProvider);
      this.provideReactorSocketUrlProvider = DoubleCheck.provider(MCLSDataModuleProvides_ProvideReactorSocketUrlFactory.create(mCLSDataModuleProvidesParam));
      this.reactorSocketProvider = ReactorSocket_Factory.create(provideOkHttpProvider, MainWebSocketListener_Factory.create(), uuidUtilsProvider, provideReactorSocketUrlProvider);
      this.bindReactorSocketProvider = DoubleCheck.provider((Provider) reactorSocketProvider);
      this.userPreferencesUtilsProvider = UserPreferencesUtils_Factory.create(bindPrefManagerProvider);
      this.provideConcurrencySocketUrlProvider = DoubleCheck.provider(MCLSDataModuleProvides_ProvideConcurrencySocketUrlFactory.create(mCLSDataModuleProvidesParam));
      this.bFFRTSocketProvider = DoubleCheck.provider(BFFRTSocket_Factory.create(provideOkHttpProvider, MainWebSocketListener_Factory.create(), userPreferencesUtilsProvider, provideConcurrencySocketUrlProvider));
    }

    @Override
    public void inject(tv.mycujoo.mclsnetwork.MCLSData.Builder mclsData) {
      injectBuilder(mclsData);
    }

    private tv.mycujoo.mclsnetwork.MCLSData.Builder injectBuilder(
        tv.mycujoo.mclsnetwork.MCLSData.Builder instance) {
      MCLSData_Builder_MembersInjector.injectPrefManager(instance, bindPrefManagerProvider.get());
      MCLSData_Builder_MembersInjector.injectLogger(instance, provideLoggerProvider.get());
      MCLSData_Builder_MembersInjector.injectDataManager(instance, bindDataManagerProvider.get());
      MCLSData_Builder_MembersInjector.injectReactorSocket(instance, bindReactorSocketProvider.get());
      MCLSData_Builder_MembersInjector.injectBffrtSocket(instance, bFFRTSocketProvider.get());
      return instance;
    }
  }
}
