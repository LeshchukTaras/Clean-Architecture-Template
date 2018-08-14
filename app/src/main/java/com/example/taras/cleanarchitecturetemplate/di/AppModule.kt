package com.example.taras.cleanarchitecturetemplate.di

import android.content.Context
import dagger.Module
import dagger.Provides
import javax.inject.Singleton
import com.example.taras.cleanarchitecturetemplate.App

@Module
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideApp(): App = app

    @Provides
    @Singleton
    fun provideAppContext(app: App): Context = app
}