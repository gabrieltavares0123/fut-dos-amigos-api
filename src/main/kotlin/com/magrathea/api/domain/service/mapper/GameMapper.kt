package com.magrathea.api.domain.service.mapper

import com.magrathea.api.data.entity.GameEntity
import com.magrathea.api.domain.dto.GameDto

fun GameDto.toEntity() =
    GameEntity(
        id = this.id,
        date = this.date,
        name = this.name,
        street = this.street,
        number = this.number,
        city = this.city,
        state = this.state,
        enrolledPlayers = this.enrolledPlayers.map { it.toEntity() }.toMutableSet(),
        owner = this.owner?.toEntity(),
    )

fun GameEntity.toDto() =
    GameDto(
        id = this.id,
        date = this.date,
        name = this.name,
        street = this.street,
        number = this.number,
        city = this.city,
        state = this.state,
        enrolledPlayers = this.enrolledPlayers.map { it.toDto() }.toMutableSet(),
        owner = this.owner?.toDto(),
    )