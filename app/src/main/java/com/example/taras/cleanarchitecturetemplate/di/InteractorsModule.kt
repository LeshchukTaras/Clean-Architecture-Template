package com.example.taras.cleanarchitecturetemplate.di

import com.taras.domain.repository.StatusRepository
import com.taras.domain.rx.GetLinesStatusInteractor
import com.taras.domain.rx.RxSchedulers
import dagger.Module
import dagger.Provides

@Module
class InteractorsModule {

    @Provides
    fun providesGetLinesStatusInteractor(
            statusRepository: StatusRepository,
            rxSchedulers: RxSchedulers) =
            GetLinesStatusInteractor(statusRepository, rxSchedulers)
}
