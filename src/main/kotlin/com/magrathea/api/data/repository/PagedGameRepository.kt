package com.magrathea.api.data.repository

import com.magrathea.api.data.entity.GameEntity
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface PagedGameRepository : PagingAndSortingRepository<GameEntity, Long> {
    fun findByEnrolledPlayers_Id(id: Long): Set<GameEntity>

    fun findAllByName(name: String, pageable: Pageable): Page<GameEntity>
}