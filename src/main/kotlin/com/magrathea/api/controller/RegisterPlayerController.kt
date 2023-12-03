package com.magrathea.api.controller

import com.magrathea.api.domain.dto.PlayerDto
import com.magrathea.api.domain.service.RegisterPlayerService
import jakarta.validation.Valid
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.servlet.support.ServletUriComponentsBuilder

@RestController
@RequestMapping("player")
class RegisterPlayerController(
    private val registerPlayerService: RegisterPlayerService,
) {
    @PostMapping
    fun createPlayer(
        @Valid @RequestBody playerDto: PlayerDto
    ): ResponseEntity<PlayerDto> {
        val createdPlayer = registerPlayerService.execute(playerDto)

        return ResponseEntity.created(
            ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdPlayer.id).toUri()
        ).build()
    }
}