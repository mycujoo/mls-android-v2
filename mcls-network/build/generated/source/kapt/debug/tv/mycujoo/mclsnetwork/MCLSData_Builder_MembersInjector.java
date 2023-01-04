package tv.mycujoo.mclsnetwork;

import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import tv.mycujoo.mclsnetwork.data.IDataManager;
import tv.mycujoo.mclsnetwork.manager.IPrefManager;
import tv.mycujoo.mclsnetwork.manager.Logger;
import tv.mycujoo.mclsnetwork.network.socket.IBFFRTSocket;
import tv.mycujoo.mclsnetwork.network.socket.IReactorSocket;

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
public final class MCLSData_Builder_MembersInjector implements MembersInjector<MCLSData.Builder> {
  private final Provider<IPrefManager> prefManagerProvider;

  private final Provider<Logger> loggerProvider;

  private final Provider<IDataManager> dataManagerProvider;

  private final Provider<IReactorSocket> reactorSocketProvider;

  private final Provider<IBFFRTSocket> bffrtSocketProvider;

  public MCLSData_Builder_MembersInjector(Provider<IPrefManager> prefManagerProvider,
      Provider<Logger> loggerProvider, Provider<IDataManager> dataManagerProvider,
      Provider<IReactorSocket> reactorSocketProvider, Provider<IBFFRTSocket> bffrtSocketProvider) {
    this.prefManagerProvider = prefManagerProvider;
    this.loggerProvider = loggerProvider;
    this.dataManagerProvider = dataManagerProvider;
    this.reactorSocketProvider = reactorSocketProvider;
    this.bffrtSocketProvider = bffrtSocketProvider;
  }

  public static MembersInjector<MCLSData.Builder> create(Provider<IPrefManager> prefManagerProvider,
      Provider<Logger> loggerProvider, Provider<IDataManager> dataManagerProvider,
      Provider<IReactorSocket> reactorSocketProvider, Provider<IBFFRTSocket> bffrtSocketProvider) {
    return new MCLSData_Builder_MembersInjector(prefManagerProvider, loggerProvider, dataManagerProvider, reactorSocketProvider, bffrtSocketProvider);
  }

  @Override
  public void injectMembers(MCLSData.Builder instance) {
    injectPrefManager(instance, prefManagerProvider.get());
    injectLogger(instance, loggerProvider.get());
    injectDataManager(instance, dataManagerProvider.get());
    injectReactorSocket(instance, reactorSocketProvider.get());
    injectBffrtSocket(instance, bffrtSocketProvider.get());
  }

  @InjectedFieldSignature("tv.mycujoo.mlsdata.MCLSData.Builder.prefManager")
  public static void injectPrefManager(MCLSData.Builder instance, IPrefManager prefManager) {
    instance.prefManager = prefManager;
  }

  @InjectedFieldSignature("tv.mycujoo.mlsdata.MCLSData.Builder.logger")
  public static void injectLogger(MCLSData.Builder instance, Logger logger) {
    instance.logger = logger;
  }

  @InjectedFieldSignature("tv.mycujoo.mlsdata.MCLSData.Builder.dataManager")
  public static void injectDataManager(MCLSData.Builder instance, IDataManager dataManager) {
    instance.dataManager = dataManager;
  }

  @InjectedFieldSignature("tv.mycujoo.mlsdata.MCLSData.Builder.reactorSocket")
  public static void injectReactorSocket(MCLSData.Builder instance, IReactorSocket reactorSocket) {
    instance.reactorSocket = reactorSocket;
  }

  @InjectedFieldSignature("tv.mycujoo.mlsdata.MCLSData.Builder.bffrtSocket")
  public static void injectBffrtSocket(MCLSData.Builder instance, IBFFRTSocket bffrtSocket) {
    instance.bffrtSocket = bffrtSocket;
  }
}
