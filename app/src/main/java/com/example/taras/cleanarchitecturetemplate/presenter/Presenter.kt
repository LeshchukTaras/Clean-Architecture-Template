package com.example.taras.cleanarchitecturetemplate.presenter

import com.example.taras.cleanarchitecturetemplate.view.MvpView

interface Presenter<V : MvpView> {

    fun attachView(mvpView: V?)

    fun detachView()
}