package dgrishkin.brainring.service

import dgrishkin.brainring.dao.entity.BaseEntity
import dgrishkin.brainring.dto.DTO
import java.util.stream.Collectors
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

abstract class AbstractDataAccessService<E : BaseEntity, D : DTO> protected constructor(
    entityClass: KClass<E>,
    dtoClass: KClass<D>
) {
    private val dtoMemberNames = dtoClass.memberProperties.map(KProperty1<D, *>::name).toSet()
    private val dtoConstructor = dtoClass.primaryConstructor
    private val entityParams = entityClass.memberProperties.filter { prop -> dtoMemberNames.contains(prop.name) }

    @Suppress("UNCHECKED_CAST")
    protected fun mapEntityToDTO(entity: E): D {
        val params = entityParams.associate { it.name to (it as KProperty1<E, Any>).get(entity) }
        val argParams = dtoConstructor?.parameters?.associate { it to params[it.name] }

        return dtoConstructor?.callBy(argParams!!)!!
    }
}