package com.example.knifestart.hotelsnights.adapter

import com.example.knifestart.domain.entity.Hotel

/**
 * Created by glebkalinichenko on 03.01.18.
 */
class HotelAdapter(var resId: Int, var selectedPost: (Hotel) -> Unit) : SingleLineAdapter<Hotel>(resId) {
    var posts: MutableList<Hotel> = mutableListOf()

    override fun addDataSource(objects: MutableList<Hotel>) {
        posts.addAll(objects)
        notifyDataSetChanged()
    }

    override fun getObjForPosition(position: Int): Any {
        return posts[position]
    }

    override fun getItemCount(): Int {
        return posts.size
    }

    override fun onSelected(position: Int) {
        selectedPost(posts.get(position))
    }
}