package tv.mycujoo.mclsnetwork.network.socket;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import tv.mycujoo.mclsnetwork.util.UuidUtils;

@ScopeMetadata
@QualifierMetadata("tv.mycujoo.mlsdata.di.ReactorUrl")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class ReactorSocket_Factory implements Factory<ReactorSocket> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<MainWebSocketListener> mainSocketListenerProvider;

  private final Provider<UuidUtils> uuidUtilsProvider;

  private final Provider<String> webSocketUrlProvider;

  public ReactorSocket_Factory(Provider<OkHttpClient> okHttpClientProvider,
      Provider<MainWebSocketListener> mainSocketListenerProvider,
      Provider<UuidUtils> uuidUtilsProvider, Provider<String> webSocketUrlProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
    this.mainSocketListenerProvider = mainSocketListenerProvider;
    this.uuidUtilsProvider = uuidUtilsProvider;
    this.webSocketUrlProvider = webSocketUrlProvider;
  }

  @Override
  public ReactorSocket get() {
    return newInstance(okHttpClientProvider.get(), mainSocketListenerProvider.get(), uuidUtilsProvider.get(), webSocketUrlProvider.get());
  }

  public static ReactorSocket_Factory create(Provider<OkHttpClient> okHttpClientProvider,
      Provider<MainWebSocketListener> mainSocketListenerProvider,
      Provider<UuidUtils> uuidUtilsProvider, Provider<String> webSocketUrlProvider) {
    return new ReactorSocket_Factory(okHttpClientProvider, mainSocketListenerProvider, uuidUtilsProvider, webSocketUrlProvider);
  }

  public static ReactorSocket newInstance(OkHttpClient okHttpClient,
      MainWebSocketListener mainSocketListener, UuidUtils uuidUtils, String webSocketUrl) {
    return new ReactorSocket(okHttpClient, mainSocketListener, uuidUtils, webSocketUrl);
  }
}
