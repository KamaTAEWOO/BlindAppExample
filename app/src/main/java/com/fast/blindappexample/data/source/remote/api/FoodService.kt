package com.fast.blindappexample.data.source.remote.api

import com.fast.blindappexample.data.model.dto.FoodListResponse
import retrofit2.http.GET

interface FoodService {

    @GET("tasty.html?mode=json&addr=%EC%A4%91%EA%B5%AC")
    suspend fun getList(): FoodListResponse
}