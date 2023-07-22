package com.fast.blindappexample.data.source.local

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.fast.blindappexample.util.DateUtil
import java.util.*


class DateConverter {

    @TypeConverter
    fun toDate(timestamp: String?) : Date? {
        return timestamp?.let { DateUtil.dbDateFormat.parse(it) }
    }

    @TypeConverter
    fun toTimeStamp(date: Date?) : String? {
        return DateUtil.dbDateFormat.format(date)
    }
}