package com.taras.data.rx

import com.taras.domain.rx.RxSchedulers
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RxSchedulersImpl @Inject constructor() : RxSchedulers {
    override fun main(): Scheduler = AndroidSchedulers.mainThread()

    override fun io(): Scheduler = Schedulers.io()

}