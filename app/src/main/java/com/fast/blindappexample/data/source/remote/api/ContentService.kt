package com.fast.blindappexample.data.source.remote.api

import com.fast.blindappexample.data.model.dto.ContentDto
import com.fast.blindappexample.data.model.dto.ContentResponse
import com.fast.blindappexample.data.model.dto.ListResponse
import retrofit2.http.*

interface ContentService {

    @GET("list")
    suspend fun getList(): ListResponse

    @POST("save")
    suspend fun saveItem(@Body contentDto: ContentDto): ContentResponse

    @POST("update")
    suspend fun updateItem(@Body contentDto: ContentDto): ContentResponse

    @DELETE("{id}")
    suspend fun deleteItem(@Path("id") id: Int): ContentResponse
}