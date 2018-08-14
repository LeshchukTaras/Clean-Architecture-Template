package com.taras.domain.repository

import com.taras.domain.model.LineStatus
import io.reactivex.Single

interface StatusRepository {

    fun getLinesStatus(): Single<List<LineStatus>>
}