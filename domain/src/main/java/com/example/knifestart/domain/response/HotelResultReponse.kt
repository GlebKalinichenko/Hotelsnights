package com.example.knifestart.domain.response

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by glebkalinichenko on 03.01.18.
 */
data class HotelResultReponse(var status: String, var results: HotelsResponse) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readParcelable(HotelsResponse::class.java.classLoader)) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(status)
        parcel.writeParcelable(results, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HotelResultReponse> {
        override fun createFromParcel(parcel: Parcel): HotelResultReponse {
            return HotelResultReponse(parcel)
        }

        override fun newArray(size: Int): Array<HotelResultReponse?> {
            return arrayOfNulls(size)
        }
    }
}