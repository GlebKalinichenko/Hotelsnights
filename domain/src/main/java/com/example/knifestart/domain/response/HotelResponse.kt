package com.example.knifestart.domain.response

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by glebkalinichenko on 03.01.18.
 */
data class HotelResponse(var locationId: Int, var fullName: String, var label: String, var _score: Double,
                         var id: String, var locationName: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readString(),
            parcel.readDouble(),
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(locationId)
        parcel.writeString(fullName)
        parcel.writeString(label)
        parcel.writeDouble(_score)
        parcel.writeString(id)
        parcel.writeString(locationName)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HotelResponse> {
        override fun createFromParcel(parcel: Parcel): HotelResponse {
            return HotelResponse(parcel)
        }

        override fun newArray(size: Int): Array<HotelResponse?> {
            return arrayOfNulls(size)
        }
    }

}