package tv.mycujoo.mcls.widget.prefs

import android.content.Context
import java.util.UUID
import javax.inject.Inject

class Preferences @Inject constructor(context: Context): IPreferences {

    private val sharedPreferences = context.getSharedPreferences(
        "MCLS-SDK-MCLS",
        Context.MODE_PRIVATE
    )

    /**
     *
     * Get Saved PseudoUserId, if Not set, will create one for you, based on Uuid.
     *
     * Usually this is set based on FirebaseAnalytics Instance Id. which represents an
     * anonymous user id.
     *
     * @return pseudoUserId,
     */
    override fun getPseudoUserId(): String {
        return sharedPreferences.getString(KEY_PSEUDO_USER_ID, "").orEmpty().ifEmpty {
            val uuid = UUID.randomUUID().toString()
            sharedPreferences.edit().putString(KEY_PSEUDO_USER_ID, uuid).apply()
            uuid
        }
    }

    override fun setPseudoUserId(pseudoUserId: String) {
        sharedPreferences.edit().putString(KEY_PSEUDO_USER_ID, pseudoUserId).apply()
    }

    override fun getUserId(): String? {
        return sharedPreferences.getString(KEY_USER_ID, null)
    }

    override fun setUserId(userId: String) {
        sharedPreferences.edit().putString(KEY_USER_ID, userId).apply()
    }

    companion object {
        const val KEY_PSEUDO_USER_ID = "PseudoUserId"
        const val KEY_USER_ID = "UserId"
    }
}