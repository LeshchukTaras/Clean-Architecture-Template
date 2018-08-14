package com.taras.data.network

import com.taras.data.network.model.LineStatusModel
import io.reactivex.Single
import retrofit2.http.GET

interface StatusService {

    @GET("Line/Mode/tube/Status")
    fun getStatus(): Single<List<LineStatusModel>>
}