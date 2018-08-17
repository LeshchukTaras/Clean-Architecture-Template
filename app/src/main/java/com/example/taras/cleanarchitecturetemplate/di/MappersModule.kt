package com.example.taras.cleanarchitecturetemplate.di

import com.example.taras.cleanarchitecturetemplate.utils.LineStatusToLineStatusPresentationMapper
import com.taras.data.utils.LineStatusModelToLineStatusMapper
import dagger.Module
import dagger.Provides

@Module
class MappersModule {

    @Provides
    fun provideLineStatusModelToLineStatusMapper() =
            LineStatusModelToLineStatusMapper()

    @Provides
    fun provideLineStatusToLineStatusPresentationMapper() =
            LineStatusToLineStatusPresentationMapper()
}