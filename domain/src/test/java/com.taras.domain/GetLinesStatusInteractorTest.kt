package com.taras.data

import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import com.taras.domain.model.LineStatus
import com.taras.domain.repository.StatusRepository
import com.taras.domain.rx.GetLineStatusInteractor
import io.reactivex.Single
import org.junit.Before
import org.junit.Test
import org.mockito.MockitoAnnotations

class GetLinesStatusInteractorTest {

    private val mockStatusRepository = mock<StatusRepository>()
    private lateinit var getLinesStatusInteractor: GetLineStatusInteractor

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        getLinesStatusInteractor = GetLineStatusInteractor(
                mockStatusRepository,
                TestRxSchedulersImpl()
        )
    }

    @Test
    fun shouldReturnErrorWhenItFailsToGetLinesStatus() {
        // given
        val throwable = Throwable()
        whenever(mockStatusRepository.getLinesStatus())
                .thenReturn(Single.error(throwable))

        // when
        val testObserver = getLinesStatusInteractor.execute().test()

        // then
        testObserver.assertError(throwable)
        verify(mockStatusRepository).getLinesStatus()
    }

    @Test
    fun shouldReturnListOfLineStatusWhenItSucceedsToGetLinesStatus() {
        // given
        whenever(mockStatusRepository.getLinesStatus())
                .thenReturn(Single.just(mutableListOf(getLineStatus())))

        // when
        val testObserver = getLinesStatusInteractor.execute().test()

        // then
        verify(mockStatusRepository).getLinesStatus()
        testObserver.assertComplete()
        testObserver.assertValue {
            it[0] == getLineStatus()
        }
    }

    private fun getLineStatus(): LineStatus {
        return LineStatus(
                id = "id",
                name = "name",
                severityLevel = "severity_level",
                severityLevelDescription = "severity_level_description"
        )
    }
}