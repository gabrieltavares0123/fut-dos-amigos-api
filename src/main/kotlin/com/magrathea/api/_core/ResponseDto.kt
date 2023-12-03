package com.magrathea.api._core

data class ResponseDto<T : Any>(
    val content: T,
    val page: Int? = null,
    val totalPages: Int? = null,
    val totalElements: Long? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
)