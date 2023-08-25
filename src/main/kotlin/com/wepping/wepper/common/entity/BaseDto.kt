package com.wepping.wepper.common.entity

import java.time.ZonedDateTime

open class BaseDto(
    val createdAt: ZonedDateTime,
    val updatedAt: ZonedDateTime,
)

open class BaseListDto<EntityDto : BaseDto> private constructor(
) {
    var data: List<EntityDto> = emptyList()
    var count: Int = 0

    companion object {
        fun <Entity : BaseEntity<EntityDto>, EntityDto : BaseDto> create(list: List<Entity>): BaseListDto<EntityDto> {
            var dto = BaseListDto<EntityDto>()
            dto.data = list.map { entity -> entity.toDto() }
            dto.count = list.size
            return dto
        }
    }
}