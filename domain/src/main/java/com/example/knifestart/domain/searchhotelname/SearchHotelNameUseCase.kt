package com.example.knifestart.domain.searchhotelname

import com.example.knifestart.domain.base.QueryUseCase
import com.example.knifestart.domain.entity.Hotel
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 02.01.18.
 */
class SearchHotelNameUseCase @Inject constructor(workScheduler: Scheduler,
                                            observeScheduler: Scheduler,
                                            private val repository: ISearchHotelNameRepository) : QueryUseCase<MutableList<Hotel>, SearchHotelNameUseCase.FetchHotelNameParam>(workScheduler, observeScheduler) {

    override fun buildUseCaseObservable(params: FetchHotelNameParam): Observable<MutableList<Hotel>> {
        return repository.fetchHotelsApi(params.limit)
    }

    class FetchHotelNameParam(offset: Int, limit: Int) {
        internal var offset: Int
        internal var limit: Int

        init {
            this.offset = offset
            this.limit = limit
        }
    }
}