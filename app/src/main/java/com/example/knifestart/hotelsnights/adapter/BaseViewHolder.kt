package com.example.knifestart.hotelsnights.adapter

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView
import com.android.databinding.library.baseAdapters.BR

/**
 * Created by glebkalinichenko on 03.01.18.
 */
class BaseViewHolder(var binding: ViewDataBinding) : RecyclerView.ViewHolder(binding.root) {

    fun bind(obj: Any) {
        binding.setVariable(BR.obj, obj)
        binding.executePendingBindings();
    }
}