package com.example.taras.cleanarchitecturetemplate.presenter

import com.example.taras.cleanarchitecturetemplate.data.getExpectedLineStatusPresentation
import com.example.taras.cleanarchitecturetemplate.data.getLineStatus
import com.example.taras.cleanarchitecturetemplate.utils.LineStatusToLineStatusPresentationMapper
import com.example.taras.cleanarchitecturetemplate.view.StatusView
import com.nhaarman.mockitokotlin2.*
import com.taras.domain.rx.GetLinesStatusInteractor
import io.reactivex.Observable
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class StatusPresenterTest {

    private val mockStatusView = mock<StatusView>()
    private val mockGetLinesStatusInteractor = mock<GetLinesStatusInteractor>()
    private lateinit var statusPresenter: StatusPresenter

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        statusPresenter = StatusPresenter(
                mockGetLinesStatusInteractor,
                LineStatusToLineStatusPresentationMapper()
        )
    }

    @Test
    fun shouldTriggerShowErrorWhenItFailsToGetLinesStatus() {
        // given
        val throwable = Throwable()
        whenever(mockGetLinesStatusInteractor.execute())
                .thenReturn(Observable.error(throwable))

        // when
        statusPresenter.attachView(mockStatusView)

        // then
        verify(mockStatusView).showLoading(true)
        verify(mockStatusView).showError()
        verify(mockStatusView).showLoading(false)
    }

    @Test
    fun shouldTriggerShowLinesStatusWhenItSucceedsToGetLinesStatus() {
        // given
        whenever(mockGetLinesStatusInteractor.execute())
                .thenReturn(Observable.just(listOf(getLineStatus())))

        // when
        statusPresenter.attachView(mockStatusView)

        // then
        verify(mockStatusView).showLoading(true)
        verify(mockStatusView).showLinesStatus(listOf(getExpectedLineStatusPresentation()))
        verify(mockStatusView).showLoading(false)
    }
}