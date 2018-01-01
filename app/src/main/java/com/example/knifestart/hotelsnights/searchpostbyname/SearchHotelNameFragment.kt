package com.example.knifestart.hotelsnights.searchpostbyname

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.knifestart.hotelsnights.R

/**
 * Created by glebkalinichenko on 31.12.17.
 */
class SearchHotelNameFragment : Fragment() {
    companion object {
        fun newInstance() : SearchHotelNameFragment {
            var fragment = SearchHotelNameFragment()
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_search_hotel_name, container, false)
        return view
    }
}