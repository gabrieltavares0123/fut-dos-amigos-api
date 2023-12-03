package com.magrathea.api.domain.service

import com.magrathea.api.data.repository.PagedGameRepository
import com.magrathea.api.domain.dto.GameDto
import com.magrathea.api.domain.service.mapper.toDto
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.stereotype.Service

@Service
class LoadGamesService(
    private val pagedGameRepository: PagedGameRepository,
) {
    fun loadGames(pageable: Pageable): Page<GameDto> {
        return pagedGameRepository.findAll(pageable).map { it.toDto() }
    }
}