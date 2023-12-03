package com.magrathea.api.domain.service

import com.magrathea.api.data.repository.GameRepository
import com.magrathea.api.data.repository.PlayerRepository
import com.magrathea.api.domain.dto.GameDto
import com.magrathea.api.domain.service.mapper.toDto
import com.magrathea.api.domain.service.mapper.toEntity
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service

@Service
class CreateGameService(
    private val gameRepository: GameRepository,
    private val playerRepository: PlayerRepository,
) {
    private val logger: Logger = LoggerFactory.getLogger(CreateGameService::class.java)

    fun create(gameDto: GameDto): GameDto {
        val playerEntity = playerRepository.findById(gameDto.owner?.id!!).get()
        val gameEntity = gameDto.toEntity()
        gameEntity.owner = playerEntity
        return gameRepository.save(gameEntity).toDto()
    }
}