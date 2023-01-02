package tv.mycujoo.annotation.domain.entity

import tv.mycujoo.mclscore.model.Variable

/**
 * A variable with offset & id
 * @see Variable
 */
data class VariableEntity(
    val id: String,
    val offset: Long,
    val variable: Variable
)
