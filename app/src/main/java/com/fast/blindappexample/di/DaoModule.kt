package com.fast.blindappexample.di

import com.fast.blindappexample.data.source.local.AppDatabase
import com.fast.blindappexample.data.source.local.dao.ContentDao
import com.fast.blindappexample.data.source.local.dao.FoodDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DaoModule {

    @Singleton
    @Provides
    fun provideContentDao(appDatabase: AppDatabase): ContentDao = appDatabase.contentDao()

    @Singleton
    @Provides
    fun provideFoodDao(appDatabase: AppDatabase): FoodDao = appDatabase.foodDao()
}