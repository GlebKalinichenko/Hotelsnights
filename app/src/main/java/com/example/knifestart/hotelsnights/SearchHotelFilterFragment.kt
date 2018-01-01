package com.example.knifestart.hotelsnights

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by glebkalinichenko on 31.12.17.
 */
class SearchHotelFilterFragment : Fragment() {
    companion object {
        fun newInstance() : SearchHotelFilterFragment {
            var fragment = SearchHotelFilterFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_search_hotel_filter, container, false)
        return view
    }
}