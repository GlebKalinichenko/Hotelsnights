package com.example.knifestart.hotelsnights.databinding_extension

import android.databinding.BindingAdapter
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.example.knifestart.hotelsnights.adapter.PaginationScrollListener
import com.example.knifestart.hotelsnights.searchhotelbyname.SearchHotelNameViewModel
import com.example.knifestart.hotelsnights.utils.SpaceItemDecoration

/**
 * Created by glebkalinichenko on 03.01.18.
 */
@BindingAdapter("setHasFixedSize")
fun setHasFixedSize(view: RecyclerView, isHasFixedSize: Boolean) {
    view.setHasFixedSize(isHasFixedSize)
}

@BindingAdapter("space")
fun space(view: RecyclerView, space: Int) {
    view.addItemDecoration(SpaceItemDecoration(space))
}

@BindingAdapter("postBindAdapter")
fun bindAdapter(view: RecyclerView, viewModel: SearchHotelNameViewModel) {
    view.layoutManager = LinearLayoutManager(view.context)
    view.adapter = viewModel.adapter
}


@BindingAdapter("scrollPagination")
fun scrollPagination(view: RecyclerView, viewModel: SearchHotelNameViewModel) {
    view.addOnScrollListener(object : PaginationScrollListener(view.layoutManager as LinearLayoutManager){
        override fun loadMoreItems() {
            var a = getTotalPageCount()
            viewModel.searchHotels("palace", getTotalPageCount() + viewModel.VISIBLE_THRESHOLD, false)
        }

        override fun getTotalPageCount() = view.adapter.itemCount

        override fun isLoading(): Boolean = viewModel.isProgressVisible()

    })
}