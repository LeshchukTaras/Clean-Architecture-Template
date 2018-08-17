package com.example.taras.cleanarchitecturetemplate.view

import com.example.taras.cleanarchitecturetemplate.model.LineStatusPresentation

interface StatusView : MvpView {

    fun showLoading(isLoading: Boolean)

    fun showLinesStatus(lineStatus: List<LineStatusPresentation>)

    fun showError()
}