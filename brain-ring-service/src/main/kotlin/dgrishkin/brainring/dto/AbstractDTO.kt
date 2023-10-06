package dgrishkin.brainring.dto

import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties

abstract class AbstractDTO(
    override val id: Long?
) : DTO {
    @Suppress("UNCHECKED_CAST")
    override fun toString(): String =
        this::class.memberProperties.associate { it.name to (it as KProperty1<DTO, Any>).get(this) }.toString()
}