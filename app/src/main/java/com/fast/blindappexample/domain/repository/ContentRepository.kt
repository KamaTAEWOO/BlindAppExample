package com.fast.blindappexample.domain.repository

import com.fast.blindappexample.domain.model.Content

interface ContentRepository {

    suspend fun save(item: Content) : Boolean
}