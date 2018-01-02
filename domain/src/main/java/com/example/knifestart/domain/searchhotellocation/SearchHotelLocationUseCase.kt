package com.example.knifestart.domain.searchhotellocation

import com.example.knifestart.domain.base.QueryUseCase
import com.example.knifestart.domain.entity.Hotel
import io.reactivex.Observable
import io.reactivex.Scheduler
import javax.inject.Inject

/**
 * Created by glebkalinichenko on 02.01.18.
 */
class SearchHotelLocationUseCase @Inject constructor(workScheduler: Scheduler,
                                                     observeScheduler: Scheduler,
                                                     private val repository: ISearchHotelLocationRepository) : QueryUseCase<MutableList<Hotel>, SearchHotelLocationUseCase.FetchHotelNameParam>(workScheduler, observeScheduler) {

    override fun buildUseCaseObservable(params: FetchHotelNameParam): Observable<MutableList<Hotel>> {
        if (!params.isOffline)
            return repository.fetchHotelsLocationApi(params.lat, params.lng)

        return repository.fetchHotelsLocationApi(params.lat, params.lng)
    }

    class FetchHotelNameParam(lat: Double, lng: Double, isOffline: Boolean) {
        internal var lat: Double
        internal var lng: Double
        internal var isOffline: Boolean

        init {
            this.lat = lat
            this.lng = lng
            this.isOffline = isOffline
        }
    }
}