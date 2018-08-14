package com.example.taras.cleanarchitecturetemplate.network

import com.example.taras.cleanarchitecturetemplate.network.model.LineStatus
import io.reactivex.Single
import retrofit2.http.GET

interface StatusService {

    @GET("Line/Mode/tube/Status")
    fun getStatus(): Single<List<LineStatus>>
}