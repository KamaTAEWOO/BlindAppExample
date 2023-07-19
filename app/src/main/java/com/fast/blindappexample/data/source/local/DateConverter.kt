package com.fast.blindappexample.data.source.local

import androidx.room.TypeConverter
import androidx.room.TypeConverters
import java.sql.Date
import java.sql.Timestamp

class DateConverter {

    @TypeConverter
    fun toDate(timestamp: String?) : Date? {
        return timestamp?.let { Date(Timestamp.valueOf(it).time) }
    }

    @TypeConverter
    fun toTimestamp(date: Date?) : String? {
        return date?.let { date.toString() }
    }
}