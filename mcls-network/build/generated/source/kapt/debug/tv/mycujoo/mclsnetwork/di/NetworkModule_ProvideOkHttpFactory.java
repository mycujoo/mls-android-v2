package tv.mycujoo.mclsnetwork.di;

import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;
import tv.mycujoo.mclsnetwork.manager.IPrefManager;

@ScopeMetadata("javax.inject.Singleton")
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
public final class NetworkModule_ProvideOkHttpFactory implements Factory<OkHttpClient> {
  private final NetworkModule module;

  private final Provider<IPrefManager> prefManagerProvider;

  private final Provider<Context> contextProvider;

  public NetworkModule_ProvideOkHttpFactory(NetworkModule module,
      Provider<IPrefManager> prefManagerProvider, Provider<Context> contextProvider) {
    this.module = module;
    this.prefManagerProvider = prefManagerProvider;
    this.contextProvider = contextProvider;
  }

  @Override
  public OkHttpClient get() {
    return provideOkHttp(module, prefManagerProvider.get(), contextProvider.get());
  }

  public static NetworkModule_ProvideOkHttpFactory create(NetworkModule module,
      Provider<IPrefManager> prefManagerProvider, Provider<Context> contextProvider) {
    return new NetworkModule_ProvideOkHttpFactory(module, prefManagerProvider, contextProvider);
  }

  public static OkHttpClient provideOkHttp(NetworkModule instance, IPrefManager prefManager,
      Context context) {
    return Preconditions.checkNotNullFromProvides(instance.provideOkHttp(prefManager, context));
  }
}
