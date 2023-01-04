package tv.mycujoo.mclsnetwork.network.socket

import okhttp3.WebSocket
import okhttp3.WebSocketListener
import javax.inject.Inject

class MainWebSocketListener @Inject constructor() : WebSocketListener() {


    private var socketListeners = mutableListOf<WebSocketListener>()

    override fun onMessage(webSocket: WebSocket, text: String) {
        super.onMessage(webSocket, text)
        for (socketListener in socketListeners) {
            socketListener.onMessage(webSocket, text)
        }
    }

    fun addListener(webSocketListener: WebSocketListener) {
        socketListeners.add(webSocketListener)
    }
}