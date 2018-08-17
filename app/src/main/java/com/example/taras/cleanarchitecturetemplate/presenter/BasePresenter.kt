package com.example.taras.cleanarchitecturetemplate.presenter

import com.example.taras.cleanarchitecturetemplate.view.MvpView
import io.reactivex.disposables.CompositeDisposable

open class BasePresenter<T : MvpView> : Presenter<T> {

    var mvpView: T? = null
    val compositeDisposable = CompositeDisposable()
    val isViewAttached = mvpView != null

    override fun attachView(mvpView: T?) {
        this.mvpView = mvpView
    }

    override fun detachView() {
        mvpView = null
        compositeDisposable.clear()
    }
}