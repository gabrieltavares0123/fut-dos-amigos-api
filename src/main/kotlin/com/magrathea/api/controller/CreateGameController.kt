package com.magrathea.api.controller

import com.magrathea.api.domain.dto.GameDto
import com.magrathea.api.domain.service.CreateGameService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("game")
class CreateGameController(
    private val createGameService: CreateGameService,
) {
    @PostMapping
    fun createGame(@RequestBody gameDto: GameDto): ResponseEntity<GameDto> {
        val createdTeam = createGameService.create(gameDto)

        return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTeam.id).toUri()
        ).build()
    }
}