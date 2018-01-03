package com.example.knifestart.hotelsnights.adapter

/**
 * Created by glebkalinichenko on 03.01.18.
 */
abstract class SingleLineAdapter<T> (var layoutId: Int) : BaseAdapter() {
    override fun getLayoutIdForPosition(position: Int): Int {
        return layoutId
    }

    abstract fun addDataSource(objects: MutableList<T>)

    abstract fun cleanAndAddDataSource(objects: MutableList<T>)
}