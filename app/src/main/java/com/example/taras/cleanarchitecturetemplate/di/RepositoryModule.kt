package com.example.taras.cleanarchitecturetemplate.di

import com.taras.data.network.StatusService
import com.taras.data.network.repository.StatusRepositoryImpl
import com.taras.data.utils.LineStatusModelToLineStatusMapper
import com.taras.domain.repository.StatusRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun providesStatusRepository(statusService: StatusService,
                                 mapper: LineStatusModelToLineStatusMapper):
            StatusRepository = StatusRepositoryImpl(statusService, mapper)
}