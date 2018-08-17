package com.example.taras.cleanarchitecturetemplate.presenter

import com.example.taras.cleanarchitecturetemplate.utils.LineStatusToLineStatusPresentationMapper
import com.example.taras.cleanarchitecturetemplate.view.StatusView
import com.taras.domain.rx.GetLinesStatusInteractor
import javax.inject.Inject

class StatusPresenter @Inject constructor(
        private val getLinesStatusInteractor: GetLinesStatusInteractor,
        private val mapper: LineStatusToLineStatusPresentationMapper
) : BasePresenter<StatusView>() {

    override fun attachView(mvpView: StatusView?) {
        super.attachView(mvpView)
        fetchLinesStatus()
    }

    fun fetchLinesStatus() {
//        if (isNetworkAvailable()) {
            compositeDisposable.add(getLinesStatusInteractor.execute()
                    .doOnSubscribe { mvpView?.showLoading(true) }
                    .flatMapIterable { it }
                    .map { mapper.map(it) }
                    .toList()
                    .doAfterTerminate { mvpView?.showLoading(false) }
                    .subscribe(
                            { linesStatus ->
                                mvpView?.showLinesStatus(linesStatus)
                            },
                            {
                                mvpView?.showError()
                            }))
//        } else {
//            mvpView?.showLoading(false)
//            mvpView?.showError("Network is unavailable !")
//        }
    }
}