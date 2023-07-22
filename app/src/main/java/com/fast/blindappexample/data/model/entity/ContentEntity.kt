package com.fast.blindappexample.data.model.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity("Content")
data class ContentEntity (

    @PrimaryKey(false)
    val id: Int,
    @ColumnInfo
    var title: String,
    @ColumnInfo
    var content: String,
    @ColumnInfo
    var category: String,
    @ColumnInfo
    val createdDate: Date,
    @ColumnInfo
    val likeCount: Int,
    @ColumnInfo
    val commentCount: Int,
    @ColumnInfo
    val viewCount: Int,
): java.io.Serializable


// 서버에 가지고 온 데이터로 지속적으로 업데이트를 해주기 때문에
// autoGenerate = false로 설정해준다.