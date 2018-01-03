package com.example.knifestart.domain.response

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by glebkalinichenko on 31.12.17.
 */
data class HotelsResponse(var locations: List<HotelResponse>) : Parcelable {
    constructor(parcel: Parcel) : this(parcel.createTypedArrayList(HotelResponse)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeTypedList(locations)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HotelsResponse> {
        override fun createFromParcel(parcel: Parcel): HotelsResponse {
            return HotelsResponse(parcel)
        }

        override fun newArray(size: Int): Array<HotelsResponse?> {
            return arrayOfNulls(size)
        }
    }
}