package com.example.knifestart.domain.entity

import android.os.Parcel
import android.os.Parcelable

/**
 * Created by glebkalinichenko on 31.12.17.
 */
data class Hotel(var locationId: Int, var fullName: String, var label: String, var _score: Double,
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

    companion object CREATOR : Parcelable.Creator<Hotel> {
        override fun createFromParcel(parcel: Parcel): Hotel {
            return Hotel(parcel)
        }

        override fun newArray(size: Int): Array<Hotel?> {
            return arrayOfNulls(size)
        }
    }
}