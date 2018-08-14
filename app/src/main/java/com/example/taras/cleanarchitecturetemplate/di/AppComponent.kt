package com.example.taras.cleanarchitecturetemplate.di

import com.example.taras.cleanarchitecturetemplate.App
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class,
    NetworkModule::class,
    RepositoryModule::class,
    MappersModule::class,
    InteractorsModule::class])
interface AppComponent {
    fun inject(app: App)
}
