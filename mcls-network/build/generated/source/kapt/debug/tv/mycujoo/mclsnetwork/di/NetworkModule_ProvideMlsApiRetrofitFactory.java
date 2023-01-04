package tv.mycujoo.mclsnetwork.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata({
    "tv.mycujoo.mlsdata.di.MLSAPI",
    "tv.mycujoo.mlsdata.di.ApiBaseUrl"
})
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class NetworkModule_ProvideMlsApiRetrofitFactory implements Factory<Retrofit> {
  private final NetworkModule module;

  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<String> baseUrlProvider;

  public NetworkModule_ProvideMlsApiRetrofitFactory(NetworkModule module,
      Provider<OkHttpClient> okHttpClientProvider, Provider<String> baseUrlProvider) {
    this.module = module;
    this.okHttpClientProvider = okHttpClientProvider;
    this.baseUrlProvider = baseUrlProvider;
  }

  @Override
  public Retrofit get() {
    return provideMlsApiRetrofit(module, okHttpClientProvider.get(), baseUrlProvider.get());
  }

  public static NetworkModule_ProvideMlsApiRetrofitFactory create(NetworkModule module,
      Provider<OkHttpClient> okHttpClientProvider, Provider<String> baseUrlProvider) {
    return new NetworkModule_ProvideMlsApiRetrofitFactory(module, okHttpClientProvider, baseUrlProvider);
  }

  public static Retrofit provideMlsApiRetrofit(NetworkModule instance, OkHttpClient okHttpClient,
      String baseUrl) {
    return Preconditions.checkNotNullFromProvides(instance.provideMlsApiRetrofit(okHttpClient, baseUrl));
  }
}
