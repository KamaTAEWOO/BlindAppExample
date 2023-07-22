package com.fast.blindappexample.data.model

import com.fast.blindappexample.data.model.dto.ContentDto
import com.fast.blindappexample.data.model.entity.ContentEntity
import com.fast.blindappexample.domain.model.Content
import java.util.*

object ContentMapper {

    fun Content.toRequest() = ContentDto (
        id = id,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount,
        commentCount = commentCount,
        viewCount = viewCount,
    )

    fun ContentDto.toContent() = Content (
        id = id,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount ?: 0,
        commentCount = commentCount ?: 0,
        viewCount = viewCount ?: 0,
        createdDate = createdDate ?: Date(),
    )

    fun Content.toEntity() = ContentEntity (
        id = id ?: 1,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount,
        commentCount = commentCount,
        viewCount = viewCount,
        createdDate = createdDate ?: Date(),
    )
}