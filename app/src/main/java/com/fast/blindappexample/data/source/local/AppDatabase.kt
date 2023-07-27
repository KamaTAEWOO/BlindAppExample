package com.fast.blindappexample.data.source.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.fast.blindappexample.data.model.entity.ContentEntity
import com.fast.blindappexample.data.model.entity.FoodEntity
import com.fast.blindappexample.data.source.local.dao.ContentDao
import com.fast.blindappexample.data.source.local.dao.FoodDao

@Database(entities = [ContentEntity::class, FoodEntity::class], version = 3)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {

    abstract fun contentDao(): ContentDao

    abstract fun foodDao(): FoodDao
}