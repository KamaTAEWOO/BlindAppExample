package com.fast.blindappexample.domain.model

import java.util.*

// 클린아키텍처의 구조라서 도메인 레이어에서 데이터 레이어를 알면 안되기 때문에 도메인에도 모델을 만들어준다.
data class Content(
    val id: Int? = null,
    val title: String,
    val content: String,
    val category: String,
    val createdDate: Date = Date(),
    val likeCount: Int = 0,
    val commentCount: Int = 0,
    val viewCount: Int = 0
) : java.io.Serializable
