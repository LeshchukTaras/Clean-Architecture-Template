package com.taras.domain.rx

import io.reactivex.Observable

interface InteractorRequest

interface Iteractor<in REQUEST: InteractorRequest, RESULT> {
    fun execute(request: REQUEST): Observable<RESULT>
}

interface NoArgIterator<RESULT> {
    fun execute(): Observable<RESULT>
}