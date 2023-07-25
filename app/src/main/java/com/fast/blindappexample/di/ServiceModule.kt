package com.fast.blindappexample.di

import com.fast.blindappexample.data.source.remote.api.ContentService
import com.fast.blindappexample.data.source.remote.api.FoodService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {

    @Singleton
    @Provides
    fun provicesContentService(retrofit: Retrofit) : ContentService = retrofit.create(ContentService::class.java)

    @Singleton
    @Provides
    fun provicesFoodService(retrofit: Retrofit) : FoodService = retrofit.create(FoodService::class.java)
}