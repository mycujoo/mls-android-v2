package tv.mycujoo.mlsdata.domain.entity

import java.io.Serializable

/**
 * Contains mutable pair of objects.
 * Imitates Kotlin Pair, but it's mutable.
 */
data class MutablePair<A, B>(
    var first: A,
    var second: B
) : Serializable {

    /**
     * Returns string representation of the [Pair] including its [first] and [second] values.
     */
    override fun toString(): String = "($first, $second)"
}
