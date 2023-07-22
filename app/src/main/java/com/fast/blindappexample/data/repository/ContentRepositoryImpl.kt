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
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ContentRepositoryImpl @Inject constructor(
    private val contentService: ContentService,
    private val contentDao: ContentDao
) : ContentRepository {
    override fun loadList(): Flow<List<Content>> {
        return flow {
            try {
                contentService.getList().data.also { list ->
                    // dto -> entity -> dao
                    contentDao.insertAll(list.map { it.toEntity() })
                }
            } finally {
                //emit을 만나게 되면 아랫쪽 emit이 실행되지 않기 떄문임.
                // 내부 디비 동작
                contentDao.selectAll().collect {
                    emit(it.map { it.toContent() })
                }
            }
        }
    }

    override suspend fun save(item: Content): Boolean {
        return try {
            contentService.saveItem(item.toRequest()).also {
                if (it.success) {
                    it.data?.let {
                        contentDao.insert(it.toEntity())
                    }
                }
            }
            contentDao.insert(item.toEntity())
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun update(item: Content): Boolean {
        return try {
            contentService.updateItem(item.toRequest()).also {
                if (it.success) {
                    it.data?.let {
                        contentDao.insert(it.toEntity())
                    }
                }
            }
            contentDao.insert(item.toEntity())
            true
        } catch (e: Exception) {
            false
        }
    }

    override suspend fun delete(item: Content): Boolean {
        return try {
            item.id?.let { id ->
                contentService.deleteItem(id).also {
                    if (it.success) {
                        contentDao.delete(item.toEntity())
                    }
                }
            }
            true
        } catch (e: Exception) {
            false
        }
    }
}