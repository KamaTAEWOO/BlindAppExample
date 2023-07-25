package com.fast.blindappexample.data.model.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("Food")
data class FoodEntity (

    @PrimaryKey(false)
    val cnt: Int,
    val opendata_id: String,
    val gng_cs: String,
    val fd_cs: String,
    val bz_nm: String,
    val tlno: String,
    val mbz_hr: String,
    val pkpl: String,
    val hp: String,
    val psb_frn: String,
    val bkn_yn: String,
    val infn_fcl: String,
    val brft_yn: String,
    val dssrt_yn: String,
    val mnu: String,
    val smpl_desc: String,
    val sbw: String,
    val bus: String,
): java.io.Serializable