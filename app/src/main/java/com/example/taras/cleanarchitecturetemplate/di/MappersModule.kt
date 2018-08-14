package com.example.taras.cleanarchitecturetemplate.di

import com.taras.data.utils.LineStatusModelToLineStatusMapper
import dagger.Module
import dagger.Provides

@Module
class MappersModule {

    @Provides
    fun provideLineStatusModelToLineStatusMapper() =
            LineStatusModelToLineStatusMapper()
}