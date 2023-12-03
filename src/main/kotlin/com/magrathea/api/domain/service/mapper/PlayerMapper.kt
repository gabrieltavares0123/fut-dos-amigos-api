package com.magrathea.api.domain.service.mapper

import com.magrathea.api.data.entity.PlayerEntity
import com.magrathea.api.domain.dto.PlayerDto

fun PlayerEntity.toDto() =
    PlayerDto(
        id = this.id,
        name = this.name,
        surname = this.surname,
        phoneNumber = this.phoneNumber,
    )

fun PlayerDto.toEntity() =
    PlayerEntity(
        id = this.id,
        name = this.name,
        surname = this.surname,
        phoneNumber = this.phoneNumber,
    )