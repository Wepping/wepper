package com.wepping.wepper.common.entity

import jakarta.persistence.Column
import jakarta.persistence.MappedSuperclass
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.ZonedDateTime


@MappedSuperclass
abstract class BaseEntity<EntityDto : BaseDto> {

    @field:CreationTimestamp
    @Column(nullable = false)
    var createdAt: ZonedDateTime = ZonedDateTime.now()

    @field:UpdateTimestamp
    @Column(nullable = false)
    var updatedAt: ZonedDateTime = ZonedDateTime.now()

    abstract fun toDto() : EntityDto
}