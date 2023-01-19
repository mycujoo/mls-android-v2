package tv.mycujoo.mclscast.helper

import org.json.JSONObject
import tv.mycujoo.mclscast.config.C.CAST_CUSTOM_PLAYLIST_URL
import tv.mycujoo.mclscast.config.C.CAST_EVENT_ID_KEY
import tv.mycujoo.mclscast.config.C.CAST_IDENTITY_TOKEN
import tv.mycujoo.mclscast.config.C.CAST_PSEUDO_USER_ID_KEY
import tv.mycujoo.mclscast.config.C.CAST_PUBLIC_KEY_KEY

object CustomDataBuilder {
    /**
     * Builds given info into JSONObject,
     * May be used for sending info to remote media client
     */
    fun build(
        id: String,
        publicKey: String?,
        pseudoUserId: String?,
        identityToken: String?
    ): JSONObject = JSONObject()
        .put(CAST_EVENT_ID_KEY, id)
        .put(CAST_PUBLIC_KEY_KEY, publicKey)
        .put(CAST_PSEUDO_USER_ID_KEY, pseudoUserId)
        .put(CAST_IDENTITY_TOKEN, identityToken)

    fun build(customPlaylistUrl: String): JSONObject = JSONObject()
        .put(CAST_CUSTOM_PLAYLIST_URL, customPlaylistUrl)
}
