package com.example.taras.cleanarchitecturetemplate

import android.app.Application
import com.example.taras.cleanarchitecturetemplate.di.AppComponent
import com.example.taras.cleanarchitecturetemplate.di.AppModule
import com.example.taras.cleanarchitecturetemplate.di.DaggerAppComponent

class App : Application() {

    lateinit var applicationComponent: AppComponent

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerAppComponent.builder()
                .appModule(AppModule(this))
                .build()
    }
}