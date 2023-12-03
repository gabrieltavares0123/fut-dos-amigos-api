package com.magrathea.api._core

interface BaseService<In, Out> {
    fun execute(input: In): Out
}