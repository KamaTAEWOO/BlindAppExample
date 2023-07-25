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

// "data": [
//    {
//      "cnt": "1",
//      "OPENDATA_ID": "1816",
//      "GNG_CS": "대구광역시 중구 삼덕동2가 149-6",
//      "FD_CS": "한식",
//      "BZ_NM": "장모님국밥",
//      "TLNO": "053-425-9347",
//      "MBZ_HR": "09:00 ~ 21:00",
//      "SEAT_CNT": "40석(룸1)",
//      "PKPL": "없음",
//      "HP": "없음",
//      "PSB_FRN": "가능한 외국어가 없습니다.",
//      "BKN_YN": "가능",
//      "INFN_FCL": "불가능",
//      "BRFT_YN": "불가능",
//      "DSSRT_YN": "가능",
//      "MNU": "[저염메뉴] 순대국밥 9,000원 <br />돼지국밥 9,000원<br />섞어국밥 9,000원<br />수육 25,000원 ~ 30,000원 <br />순대한접시 12,000원",
//      "SMPL_DESC": "장모님국밥은 대구에서 유일한 특별한 돼지국밥을 제공하는 전문점입니다.",
//      "SBW": "지하철 2호선 경대병원역 1번 출구에서 도보로 약 123m 거리.",
//      "BUS": "버스 정류장은 경북대학교병원앞 정류장이 가장 가깝습니다."
//    },