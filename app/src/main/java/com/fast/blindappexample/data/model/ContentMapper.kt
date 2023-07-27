package com.fast.blindappexample.data.model

import com.fast.blindappexample.data.model.dto.ContentDto
import com.fast.blindappexample.data.model.dto.FoodDto
import com.fast.blindappexample.data.model.entity.ContentEntity
import com.fast.blindappexample.data.model.entity.FoodEntity
import com.fast.blindappexample.data.source.local.dao.ContentDao
import com.fast.blindappexample.data.source.local.dao.FoodDao
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

    fun ContentEntity.toContent() = Content (
        id = id,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount,
        commentCount = commentCount,
        viewCount = viewCount,
        createdDate = createdDate,
    )

    fun ContentDto.toEntity() = ContentEntity (
        id = id ?: -1,
        title = title,
        content = content,
        category = category,
        likeCount = likeCount ?: 0,
        commentCount = commentCount ?: 0,
        viewCount = viewCount ?: 0,
        createdDate = createdDate ?: Date(),
    )

    // Food
    // FoodDto 변수와 이름이 같아야함.
    fun FoodDto.toEntity() = FoodEntity (
        cnt = cnt ?: "null",
        opendataId = OPENDATA_ID ?: "null",
        gngCs = GNG_CS ?: "null",
        fdCs = FD_CS ?: "null",
        bzNm = BZ_NM ?: "null",
        tlno = TLNO ?: "null",
        mbzHr = MBZ_HR ?: "null",
        seatCnt = SEAT_CNT ?: "null",
        pkpl = PKPL ?: "null",
        hp = HP ?: "null",
        psbFrn = PSB_FRN ?: "null",
        bknYn = BKN_YN ?: "null",
        infnFcl = INFN_FCL ?: "null",
        brftYn = BRFT_YN ?: "null",
        dssrtYn = DSSRT_YN ?: "null",
        mnu = MNU ?: "null",
        smplDesc = SMPL_DESC ?: "null",
        sbw = SBW ?: "null",
        bus = BUS ?: "null",
    )
}