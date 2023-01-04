package tv.mycujoo.mclsnetwork.network.socket;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import tv.mycujoo.mclsnetwork.util.UserPreferencesUtils;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("tv.mycujoo.mlsdata.di.ConcurrencySocketUrl")
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class BFFRTSocket_Factory implements Factory<BFFRTSocket> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<MainWebSocketListener> mainSocketListenerProvider;

  private final Provider<UserPreferencesUtils> userPreferencesUtilsProvider;

  private final Provider<String> webSocketUrlProvider;

  public BFFRTSocket_Factory(Provider<OkHttpClient> okHttpClientProvider,
      Provider<MainWebSocketListener> mainSocketListenerProvider,
      Provider<UserPreferencesUtils> userPreferencesUtilsProvider,
      Provider<String> webSocketUrlProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
    this.mainSocketListenerProvider = mainSocketListenerProvider;
    this.userPreferencesUtilsProvider = userPreferencesUtilsProvider;
    this.webSocketUrlProvider = webSocketUrlProvider;
  }

  @Override
  public BFFRTSocket get() {
    return newInstance(okHttpClientProvider.get(), mainSocketListenerProvider.get(), userPreferencesUtilsProvider.get(), webSocketUrlProvider.get());
  }

  public static BFFRTSocket_Factory create(Provider<OkHttpClient> okHttpClientProvider,
      Provider<MainWebSocketListener> mainSocketListenerProvider,
      Provider<UserPreferencesUtils> userPreferencesUtilsProvider,
      Provider<String> webSocketUrlProvider) {
    return new BFFRTSocket_Factory(okHttpClientProvider, mainSocketListenerProvider, userPreferencesUtilsProvider, webSocketUrlProvider);
  }

  public static BFFRTSocket newInstance(OkHttpClient okHttpClient,
      MainWebSocketListener mainSocketListener, UserPreferencesUtils userPreferencesUtils,
      String webSocketUrl) {
    return new BFFRTSocket(okHttpClient, mainSocketListener, userPreferencesUtils, webSocketUrl);
  }
}
