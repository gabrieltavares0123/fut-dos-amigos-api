package com.magrathea.api.data.repository

import com.magrathea.api.data.entity.PlayerEntity
import org.springframework.data.repository.PagingAndSortingRepository
import org.springframework.stereotype.Repository

@Repository
interface PagedPlayerRepository : PagingAndSortingRepository<PlayerEntity, Long>