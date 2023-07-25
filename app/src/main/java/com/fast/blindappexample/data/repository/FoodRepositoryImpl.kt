package com.fast.blindappexample.data.repository

import com.fast.blindappexample.data.model.ContentMapper.toEntity
import com.fast.blindappexample.data.source.local.dao.FoodDao
import com.fast.blindappexample.data.source.remote.api.FoodService
import com.fast.blindappexample.domain.model.Food
import com.fast.blindappexample.domain.repository.FoodRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FoodRepositoryImpl @Inject constructor(
    private val foodService: FoodService,
    private val foodDao: FoodDao
) : FoodRepository {

    override fun loadList(): Flow<List<Food>> {
        return flow {
            try {
                foodService.getList().data.also{ list ->
                    foodDao.insertAll(list.map { it.toEntity() })
                }
            }catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}