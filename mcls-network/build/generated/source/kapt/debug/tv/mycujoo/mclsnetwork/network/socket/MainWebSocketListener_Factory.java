package tv.mycujoo.mclsnetwork.network.socket;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class MainWebSocketListener_Factory implements Factory<MainWebSocketListener> {
  @Override
  public MainWebSocketListener get() {
    return newInstance();
  }

  public static MainWebSocketListener_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static MainWebSocketListener newInstance() {
    return new MainWebSocketListener();
  }

  private static final class InstanceHolder {
    private static final MainWebSocketListener_Factory INSTANCE = new MainWebSocketListener_Factory();
  }
}
