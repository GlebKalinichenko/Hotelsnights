package com.example.knifestart.hotelsnights

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_navigation.setOnNavigationItemSelectedListener(
                object : BottomNavigationView.OnNavigationItemSelectedListener {
                    override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
                        var fragment: Fragment? = null

                        when (item.getItemId()) {
                            R.id.search_name -> fragment = SearchHotelNameFragment.newInstance()
                            R.id.search_location -> fragment = SearchHotelLocationFragment.newInstance()
                            R.id.search_filter -> fragment = SearchHotelFilterFragment.newInstance()
                        }

                        val transaction = supportFragmentManager.beginTransaction()
                        transaction.replace(R.id.fragment_container, fragment)
                        transaction.commit()
                        return true
                    }
                });
    }
}
