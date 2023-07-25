package com.fast.blindappexample.domain.repository

import com.fast.blindappexample.domain.model.Food
import kotlinx.coroutines.flow.Flow

interface FoodRepository {

    fun loadList() : Flow<List<Food>>
}