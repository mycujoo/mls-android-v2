package tv.mycujoo.mclsplayer.player.user

import android.content.Context
import android.content.Context.MODE_PRIVATE
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserPrefs @Inject constructor(
    context: Context
) {

    private val prefs = context.getSharedPreferences(KEY_PREFS_NAME, MODE_PRIVATE)

    fun getPseudoUserId(): String {
        return prefs.getString(KEY_PSEUDO_USER_ID, null).orEmpty().ifEmpty {
            val uuid = UUID.randomUUID().toString()
            prefs.edit().putString(KEY_PSEUDO_USER_ID, uuid).apply()
            uuid
        }
    }

    fun setPseudoUserId(pseudoUserId: String) {
        prefs.edit().putString(KEY_PSEUDO_USER_ID, pseudoUserId).apply()
    }

    fun setUserId(userId: String) {
        prefs.edit().putString(KEY_USER_ID, userId).apply()
    }

    fun getUserId(): String? {
        return prefs.getString(KEY_USER_ID, null)
    }

    companion object {
        const val KEY_PREFS_NAME = "MCLS-SDK-VideoPlayer"
        const val KEY_PSEUDO_USER_ID = "pseudoUserName"
        const val KEY_USER_ID = "pseudoUserName"
    }
}