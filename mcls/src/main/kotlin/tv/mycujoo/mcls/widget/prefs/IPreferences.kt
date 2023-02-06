package tv.mycujoo.mcls.widget.prefs

interface IPreferences {
    fun getPseudoUserId(): String

    fun setPseudoUserId(pseudoUserId: String)

    fun getUserId(): String?

    fun setUserId(userId: String)
}
