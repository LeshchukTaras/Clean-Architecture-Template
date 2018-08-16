package com.taras.data

import com.taras.domain.rx.RxSchedulers
import io.reactivex.Scheduler
import io.reactivex.schedulers.Schedulers

class TestRxSchedulersImpl : RxSchedulers {

    override fun main(): Scheduler = Schedulers.trampoline()

    override fun io(): Scheduler = Schedulers.trampoline()

}