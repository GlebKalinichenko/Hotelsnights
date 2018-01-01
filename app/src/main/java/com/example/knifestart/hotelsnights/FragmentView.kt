package com.example.knifestart.hotelsnights

import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by glebkalinichenko on 31.12.17.
 */
abstract class FragmentView<T> : Fragment() {
    lateinit var binding: ViewDataBinding
    var component: T? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = super.onCreateView(inflater, container, savedInstanceState)
        injectDependencies(getActivityComponent()!!)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setState()
    }

    protected fun getActivityComponent(): T? {
        if (null != component) {
            return component
        }
        val retainedObject = activity!!.getLastCustomNonConfigurationInstance()
        if (retainedObject != null) {
            //we are retaining the object, so we can safely cast it to our component class.
            component = retainedObject as T
        } else {
            component = createComponent()
        }
        return component
    }

    abstract fun injectDependencies(component: T)

    abstract fun createComponent(): T

    abstract fun setState()
}