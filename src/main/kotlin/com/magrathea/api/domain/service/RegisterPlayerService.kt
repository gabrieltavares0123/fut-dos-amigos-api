package com.magrathea.api.domain.service

import com.magrathea.api._core.BaseService
import com.magrathea.api.data.repository.PlayerRepository
import com.magrathea.api.domain.dto.PlayerDto
import com.magrathea.api.domain.service.mapper.toDto
import com.magrathea.api.domain.service.mapper.toEntity
import org.springframework.stereotype.Service

@Service
class RegisterPlayerService(
    private val playerRepository: PlayerRepository,
) : BaseService<PlayerDto, PlayerDto> {
    override fun execute(input: PlayerDto): PlayerDto {
        val playerEntity = input.toEntity()
        return playerRepository.save(playerEntity).toDto()
    }
}