package com.taras.domain.rx

import com.taras.domain.model.LineStatus
import com.taras.domain.repository.StatusRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetLinesStatusInteractor @Inject constructor(
        private val statusRepository: StatusRepository,
        private val rxSchedulers: RxSchedulers
) : NoArgIterator<List<LineStatus>> {

    override fun execute(): Observable<List<LineStatus>> =
            statusRepository.getLinesStatus()
                    .subscribeOn(rxSchedulers.io())
                    .observeOn(rxSchedulers.main())
                    .toObservable()
}