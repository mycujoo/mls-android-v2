package tv.mycujoo.mclsnetwork.util

import tv.mycujoo.mclsnetwork.enum.C
import tv.mycujoo.mclsnetwork.manager.IPrefManager
import javax.inject.Inject

class UserPreferencesUtils @Inject constructor(
    val prefManager: IPrefManager
) {

    private var mPseudoUserId: String? = null

    /**
     * Generate Pseudo User Id when not persisted, and persist one if  not exist
     */
    fun getPseudoUserId() = mPseudoUserId ?: run {
        val storedId = prefManager.get(C.PSEUDO_USER_ID_PREF_KEY)
        if (!storedId.isNullOrEmpty()) {
            storedId
        } else {
            val id = generatePseudoUserId()
            prefManager.persist(C.PSEUDO_USER_ID_PREF_KEY, id)
            id
        }
    }

    fun setPseudoUserId(pseudoUserId: String) {
        prefManager.persist(C.PSEUDO_USER_ID_PREF_KEY, pseudoUserId)
        this.mPseudoUserId = pseudoUserId
    }

    fun getIdentityToken(): String? {
        return prefManager.get(C.IDENTITY_TOKEN_PREF_KEY)
    }

    /**
     * Random User Id Generator
     */
    private fun generatePseudoUserId(): String {
        val allowedChars = ('A'..'Z') + ('a'..'z') + ('0'..'9')
        val length = 26
        return (1..length)
            .map { allowedChars.random() }
            .joinToString("")
    }
}
