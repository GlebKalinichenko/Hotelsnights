package com.example.knifestart.domain.base

import io.reactivex.Observable
import io.reactivex.Scheduler

/**
 * Created by glebkalinichenko on 02.01.18.
 */
abstract class NoArgQueryUseCase<R>(private val mWorkScheduler: Scheduler, private val mObserveScheduler: Scheduler) {

    fun run(): Observable<R> {
        return buildUseCaseObservable()
                .subscribeOn(mWorkScheduler)
                .observeOn(mObserveScheduler)
    }

    protected abstract fun buildUseCaseObservable(): Observable<R>

}
