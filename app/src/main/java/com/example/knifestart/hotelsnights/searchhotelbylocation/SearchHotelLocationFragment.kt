package com.example.knifestart.hotelsnights.searchhotelbylocation

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.knifestart.hotelsnights.R

/**
 * Created by glebkalinichenko on 31.12.17.
 */
class SearchHotelLocationFragment : Fragment() {
    companion object {
        fun newInstance() : SearchHotelLocationFragment {
            var fragment = SearchHotelLocationFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_search_hotel_location, container, false)
        return view
    }
}