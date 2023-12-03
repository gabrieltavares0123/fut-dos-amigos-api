package com.magrathea.api.domain.dto

import com.magrathea.api.data.entity.GameEntity

data class PlayerDto(
    val id: Long? = null,
    val name: String,
    val surname: String,
    val phoneNumber: String,
    val enrolledGames: MutableSet<GameEntity> = mutableSetOf(),
    val ownedGames: MutableSet<GameEntity> = mutableSetOf()
)