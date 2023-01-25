package tv.mycujoo.mclsima

/**
 * Contract to support custom parameter logging in IMA
 */
interface IParamProvider {
    /**
     * Map of key-value for logging custom
     */
    fun params(): Map<String, String>
}