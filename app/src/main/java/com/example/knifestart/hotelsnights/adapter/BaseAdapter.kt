package com.example.knifestart.hotelsnights.adapter

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by glebkalinichenko on 03.01.18.
 */
abstract class BaseAdapter : RecyclerView.Adapter<BaseViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BaseViewHolder {
        var layoutInflater = LayoutInflater.from(parent!!.getContext())
        val binding = DataBindingUtil.inflate<ViewDataBinding>(layoutInflater, viewType, parent, false)
        return BaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: BaseViewHolder?, position: Int) {
        var obj = getObjForPosition(position)
        holder!!.bind(obj)

        holder.binding.root.setOnClickListener {
            onSelected(position)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return getLayoutIdForPosition(position)
    }

    internal abstract fun getObjForPosition(position: Int): Any

    internal abstract fun getLayoutIdForPosition(position: Int): Int

    internal abstract fun onSelected(position: Int)
}