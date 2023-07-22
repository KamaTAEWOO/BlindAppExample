package com.fast.blindappexample.data.repository

import com.fast.blindappexample.data.model.ContentMapper.toEntity
import com.fast.blindappexample.data.model.ContentMapper.toRequest
import com.fast.blindappexample.data.source.local.dao.ContentDao
import com.fast.blindappexample.data.source.remote.api.ContentService
import com.fast.blindappexample.domain.model.Content
import com.fast.blindappexample.domain.repository.ContentRepository
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val contentService: ContentService,
    private val contentDao: ContentDao
) : ContentRepository {

    override suspend fun save(item: Content): Boolean {
        return try {
            val response = contentService.saveItem(item.toRequest())
            contentDao.insert(item.toEntity())
            response.success
        } catch (e: Exception) {
            false
        }
    }
}