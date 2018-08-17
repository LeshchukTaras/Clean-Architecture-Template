package com.example.taras.cleanarchitecturetemplate.di

import com.example.taras.cleanarchitecturetemplate.App
import com.example.taras.cleanarchitecturetemplate.StatusActivity
import com.taras.data.di.NetworkModule
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

    fun inject(statusActivity: StatusActivity)
}
