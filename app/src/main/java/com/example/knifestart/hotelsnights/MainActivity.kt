package com.example.knifestart.hotelsnights

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.annotation.NonNull
import kotlinx.android.synthetic.main.activity_main.*
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import android.widget.Toast
import com.example.knifestart.hotelsnights.searchhotelbylocation.SearchHotelLocationFragment
import com.example.knifestart.hotelsnights.searchhotelbyname.SearchHotelNameFragment
import com.example.knifestart.hotelsnights.searchhotelfilter.SearchHotelFilterFragment
import ru.terrakok.cicerone.NavigatorHolder
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import ru.terrakok.cicerone.commands.Command
import ru.terrakok.cicerone.commands.Replace
import javax.inject.Inject


class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var navigationHolder: NavigatorHolder

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MainApplication).mainActivityComponent.inject(this)

        bottom_navigation.setOnNavigationItemSelectedListener(
                object : BottomNavigationView.OnNavigationItemSelectedListener {
                    override fun onNavigationItemSelected(@NonNull item: MenuItem): Boolean {
                        var fragment: Fragment? = null

                        when (item.getItemId()) {
                            R.id.search_name -> navigator.applyCommand(Replace(SearchHotelNameFragment.javaClass.canonicalName, 1))
                            R.id.search_location -> navigator.applyCommand(Replace(SearchHotelLocationFragment.javaClass.canonicalName, 1))
                            R.id.search_filter -> navigator.applyCommand(Replace(SearchHotelFilterFragment.javaClass.canonicalName, 1))
                        }

                        return true
                    }
                });

        if (savedInstanceState == null) {
            navigator.applyCommand(Replace(SearchHotelNameFragment.javaClass.canonicalName, 1))
        }
    }

    private val navigator = object : SupportFragmentNavigator(supportFragmentManager, R.id.fragment_container) {
        override fun createFragment(screenKey: String, data: Any): Fragment {
            if (screenKey.equals(SearchHotelNameFragment.javaClass.canonicalName)) {
                return SearchHotelNameFragment.newInstance()
            }

            if (screenKey.equals(SearchHotelLocationFragment.javaClass.canonicalName)) {
                return SearchHotelLocationFragment.newInstance()
            }

            return SearchHotelFilterFragment.newInstance()
        }

        override fun showSystemMessage(message: String) {
            Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT).show()
        }

        override fun exit() {
            finish()
        }

        override fun applyCommand(command: Command?) {
            super.applyCommand(command)
        }
    }

    override fun onResume() {
        super.onResume()
        navigationHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        navigationHolder.removeNavigator()
    }
}
