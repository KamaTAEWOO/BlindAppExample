package com.fast.blindappexample.domain.usecase

import com.fast.blindappexample.data.source.local.dao.ContentDao
import com.fast.blindappexample.domain.model.Content
import com.fast.blindappexample.domain.repository.ContentRepository
import javax.inject.Inject

class ContentUseCase @Inject constructor(
    private val contentRepository: ContentRepository,
) {
    suspend fun save(item: Content): Boolean = contentRepository.save(item)
}