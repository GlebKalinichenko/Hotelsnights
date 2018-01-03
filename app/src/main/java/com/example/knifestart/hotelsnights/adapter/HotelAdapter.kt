package com.example.knifestart.hotelsnights.adapter

import com.example.knifestart.domain.entity.Hotel

/**
 * Created by glebkalinichenko on 03.01.18.
 */
class HotelAdapter(var resId: Int, var selectedPost: (Hotel) -> Unit) : SingleLineAdapter<Hotel>(resId) {
    var hotels: MutableList<Hotel> = mutableListOf()

    override fun addDataSource(objects: MutableList<Hotel>) {
        var prevHotelsCount = hotels.size
        hotels.addAll(objects)
        notifyItemRangeInserted(prevHotelsCount, hotels.size)
    }

    override fun cleanAndAddDataSource(objects: MutableList<Hotel>) {
        hotels.clear()
        hotels.addAll(objects)
        notifyDataSetChanged()
    }

    override fun getObjForPosition(position: Int): Any {
        return hotels[position]
    }

    override fun getItemCount(): Int {
        return hotels.size
    }

    override fun onSelected(position: Int) {
        selectedPost(hotels.get(position))
    }
}