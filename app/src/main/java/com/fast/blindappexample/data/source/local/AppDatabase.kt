package com.fast.blindappexample.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fast.blindappexample.data.model.entity.ContentEntity
import com.fast.blindappexample.data.source.local.dao.ContentDao

@Database(entities = [ContentEntity::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contentDao(): ContentDao
}