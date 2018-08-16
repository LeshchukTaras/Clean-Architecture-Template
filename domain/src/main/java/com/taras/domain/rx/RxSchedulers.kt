package com.taras.domain.rx

import io.reactivex.Scheduler

interface RxSchedulers {

    fun main(): Scheduler

    fun io(): Scheduler
}