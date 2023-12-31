package com.fast.blindappexample.domain.usecase

import com.fast.blindappexample.domain.repository.FoodRepository
import javax.inject.Inject

class FoodUseCase @Inject constructor(
    private val FoodRepository: FoodRepository,
) {

    fun loadList() = FoodRepository.loadList()
}