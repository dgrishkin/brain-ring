package dgrishkin.brainring.service

import dgrishkin.brainring.dao.entity.BaseEntity
import dgrishkin.brainring.dto.DTO
import java.util.stream.Collectors
import kotlin.reflect.KClass
import kotlin.reflect.KProperty1
import kotlin.reflect.full.memberProperties
import kotlin.reflect.full.primaryConstructor

abstract class AbstractDataAccessService<D: DTO> protected constructor(private val dtoClass: KClass<D>) {

    @Suppress("UNCHECKED_CAST")
    protected fun<E: BaseEntity> mapEntityToDTO(entity: E): D {
        val dtoMemberNames = dtoClass.memberProperties.map { prop -> prop.name }.toSet()
        val params = entity::class.memberProperties
            .filter{ prop -> dtoMemberNames.contains(prop.name) }
            .associate { it.name to (it as KProperty1<E, Any>).get(entity) }
        val argParams = dtoClass.primaryConstructor?.parameters?.associate { it to params[it.name] }

        return dtoClass.primaryConstructor?.callBy(argParams!!)!!
    }
}