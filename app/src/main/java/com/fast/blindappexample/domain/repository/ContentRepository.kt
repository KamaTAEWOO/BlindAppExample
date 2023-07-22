package com.fast.blindappexample.domain.repository

import com.fast.blindappexample.domain.model.Content
import kotlinx.coroutines.flow.Flow

interface ContentRepository {

    fun loadList() : Flow<List<Content>>

    suspend fun save(item: Content) : Boolean

    suspend fun update(item: Content) : Boolean
}