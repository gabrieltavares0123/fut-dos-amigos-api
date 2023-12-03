package com.magrathea.api.controller

import com.magrathea.api.domain.dto.GameDto
import com.magrathea.api.domain.service.CreateGameService
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.v3.oas.annotations.Operation
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
    @Operation(
        summary = "Create a new Game",
        description = "Create a new Game in the system"
    )
    @ApiResponses(
        value = [
            ApiResponse(code = 201, message = "Created")
        ]
    )
    @PostMapping
    fun createGame(@RequestBody gameDto: GameDto): ResponseEntity<GameDto> {
        val createdTeam = createGameService.create(gameDto)

        return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdTeam.id).toUri()
        ).build()
    }
}