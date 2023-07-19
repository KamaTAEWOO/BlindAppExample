package com.fast.blindappexample.data.model.dto

import java.util.*

data class ContentDto (
    val id: Int,
    val title: String,
    val content: String,
    val category: String,
    val createDate: Date? = null,
    val likeCount: Int? = 0,
    val commentCount: Int,
    val viewCount: Int? = 0,
)