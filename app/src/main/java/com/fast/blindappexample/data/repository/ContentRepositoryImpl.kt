package com.fast.blindappexample.data.repository

import com.fast.blindappexample.data.model.ContentMapper.toContent
import com.fast.blindappexample.data.model.ContentMapper.toEntity
import com.fast.blindappexample.data.model.ContentMapper.toRequest
import com.fast.blindappexample.data.source.local.dao.ContentDao
import com.fast.blindappexample.data.source.remote.api.ContentService
import com.fast.blindappexample.domain.model.Content
import com.fast.blindappexample.domain.repository.ContentRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val contentService: ContentService,
    private val contentDao: ContentDao
) : ContentRepository {
    override fun loadList(): Flow<List<Content>> {
        return flow {
            contentDao.selectAll().collect {
                emit(it.map { it.toContent() })
            }
            emit(
                try {
                    contentService.getList().data.map { it.toContent() }
                } catch (e: Exception) {
                    emptyList()
                }
            )
        }
    }

    override suspend fun save(item: Content): Boolean {
        return try {
            contentService.saveItem(item.toRequest())
            contentDao.insert(item.toEntity())
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun update(item: Content): Boolean {
        return try {
            contentService.updateItem(item.toRequest())
            contentDao.insert(item.toEntity())
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun delete(item: Content): Boolean {
        return try {
            item.id?.let { contentService.deleteItem(it) }
            contentDao.delete(item.toEntity())
            true
        } catch (e: Exception) {
            false
        }
    }
}