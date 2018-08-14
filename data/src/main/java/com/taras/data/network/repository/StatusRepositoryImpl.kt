package com.taras.data.network.repository

import com.taras.data.network.StatusService
import com.taras.data.utils.LineStatusModelToLineStatusMapper
import com.taras.domain.model.LineStatus
import com.taras.domain.repository.StatusRepository
import io.reactivex.Single
import javax.inject.Inject

class StatusRepositoryImpl @Inject constructor(
        private val statusService: StatusService,
        private val mapper: LineStatusModelToLineStatusMapper
) : StatusRepository {

    override fun getLinesStatus(): Single<List<LineStatus>> {
        return statusService.getStatus()
                .flattenAsObservable { it }
                .map { mapper.map(it) }
                .toList()
    }
}