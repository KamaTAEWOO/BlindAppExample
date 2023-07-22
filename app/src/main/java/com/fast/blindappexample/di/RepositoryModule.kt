package com.fast.blindappexample.di

import com.fast.blindappexample.data.repository.ContentRepositoryImpl
import com.fast.blindappexample.data.source.local.dao.ContentDao
import com.fast.blindappexample.data.source.remote.api.ContentService
import com.fast.blindappexample.domain.repository.ContentRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object RepositoryModule {

    @Provides
    @ViewModelScoped
    fun provideContentRepository(
        contentService: ContentService,
        contentDao: ContentDao
    ): ContentRepository = ContentRepositoryImpl(contentService, contentDao)
}