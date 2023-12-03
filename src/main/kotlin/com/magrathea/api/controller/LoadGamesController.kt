package com.magrathea.api.controller

import com.magrathea.api.domain.dto.GameDto
import com.magrathea.api._core.ResponseDto
import com.magrathea.api.domain.service.LoadGamesService
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import io.swagger.v3.oas.annotations.Operation
import org.springframework.data.domain.PageRequest
import org.springframework.data.domain.Pageable
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("game")
class LoadGamesController(
    private val loadGamesService: LoadGamesService,
) {
    @Operation(
        summary = "Load all Games",
        description = "Load all Games"
    )
    @ApiResponses(
        value = [
            ApiResponse(code = 200, message = "Ok"),
            ApiResponse(code = 204, message = "No Content")
        ]
    )
    @GetMapping
    fun loadGames(
        @RequestParam page: Int,
        @RequestParam size: Int,
    ): ResponseEntity<ResponseDto<Set<GameDto>>> {
        val pageRequest: Pageable = PageRequest.of(page, size)

        val games = loadGamesService.loadGames(pageRequest)
        val response: ResponseDto<Set<GameDto>> = ResponseDto(
            content = games.content.toSet(),
            page = games.number,
            totalElements = games.totalElements,
            totalPages = games.totalPages,
            prevPage = if (page > 0 ) page - 1 else null,
            nextPage = if (page + 1 < games.totalPages) page + 1 else null
        )

        return ResponseEntity.ok(response)
    }
}