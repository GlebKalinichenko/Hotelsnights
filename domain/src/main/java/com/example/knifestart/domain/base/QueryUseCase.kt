package com.example.knifestart.domain.base

import io.reactivex.Observable
import io.reactivex.Scheduler

/**
 * Created by glebkalinichenko on 02.01.18.
 */
abstract class QueryUseCase<R, T> protected constructor(private val mWorkScheduler: Scheduler, private val mObserveScheduler: Scheduler) {

    fun run(params: T): Observable<R> {
        return buildUseCaseObservable(params)
                .subscribeOn(mWorkScheduler)
                .observeOn(mObserveScheduler)
    }

    protected abstract fun buildUseCaseObservable(params: T): Observable<R>


}