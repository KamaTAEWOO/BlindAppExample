package com.fast.blindappexample.data.source.local.dao

import androidx.room.*
import com.fast.blindappexample.data.model.entity.ContentEntity
import com.fast.blindappexample.data.model.entity.FoodEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FoodDao {

    @Query("SELECT * FROM Food")
    fun selectAll() : Flow<List<FoodEntity>>

    @Delete
    suspend fun delete(item: FoodEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: FoodEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(items: List<FoodEntity>)
}