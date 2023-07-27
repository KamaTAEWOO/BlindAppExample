package com.fast.blindappexample.data.model.dto

data class ListResponse(
    val success: Boolean,
    val code: Int,
    val message: String,
    val data: List<ContentDto>
)

data class ContentResponse(
    val success: Boolean,
    val code: Int,
    val message: String,
    val data: ContentDto?
)

data class FoodListResponse(
    val status: String,
    val total: Int,
    val data: List<FoodDto>
)