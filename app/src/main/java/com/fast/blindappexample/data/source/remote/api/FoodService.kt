package com.fast.blindappexample.data.source.remote.api

import com.fast.blindappexample.data.model.dto.FoodListResponse
import retrofit2.http.GET

interface FoodService {

    @GET("list")
    suspend fun getList(): FoodListResponse
}