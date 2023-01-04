package tv.mycujoo.mclsnetwork.network.socket

import android.os.Handler
import android.os.Looper
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.WebSocket
import timber.log.Timber
import tv.mycujoo.mclsnetwork.di.ConcurrencySocketUrl
import tv.mycujoo.mclsnetwork.util.UserPreferencesUtils
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BFFRTSocket @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val mainSocketListener: MainWebSocketListener,
    private val userPreferencesUtils: UserPreferencesUtils,
    @ConcurrencySocketUrl private val webSocketUrl: String,
) : IBFFRTSocket {

    private var webSocket: WebSocket? = null

    override fun addListener(BFFRTCallback: BFFRTCallback) {
        mainSocketListener.addListener(BFFRTListener(BFFRTCallback))
    }

    override fun startSession(eventId: String, identityToken: String?) {
        if (webSocket == null) {
            createSocket(eventId)
        }

        Timber.d("$DEVICE_ID${userPreferencesUtils.getPseudoUserId()}")
        webSocket?.send("$DEVICE_ID${userPreferencesUtils.getPseudoUserId()}")

        if (identityToken != null) {
            Timber.d("$IDENTITY_TOKEN$identityToken")
            webSocket?.send("$IDENTITY_TOKEN$identityToken")
        }
    }

    override fun leaveCurrentSession() {
        try {
            webSocket?.close(NORMAL_CLOSURE_STATUS_CODE, null)
            Handler(Looper.myLooper() ?: Looper.getMainLooper()).postDelayed(
                {
                    webSocket?.cancel()
                    webSocket = null
                },
                300 // Gives the Server 300 Millis to close the connection gracefully (STATUS_CODE 1000)
            )
        } catch (socketError: IllegalArgumentException) {
            Timber.e("Error Closing the Socket ${socketError.message}")
        }
    }

    private fun createSocket(eventId: String) {
        val request = Request.Builder().url("$webSocketUrl/events/$eventId").build()
        webSocket = okHttpClient.newWebSocket(request, mainSocketListener)
    }
}