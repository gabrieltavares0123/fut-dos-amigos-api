package com.magrathea.api.domain.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class GameDto(
    val id: Long?,
    @JsonFormat(pattern = "yyyy-MM-dd")
    val date: LocalDate,
    val name: String,
    val street: String,
    val number: String,
    val city: String,
    val state: String,
    val enrolledPlayers: MutableSet<PlayerDto> = mutableSetOf(),
    val owner: PlayerDto?,
)