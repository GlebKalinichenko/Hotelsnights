package com.example.knifestart.hotelsnights.base

import android.databinding.DataBindingUtil
import android.databinding.ViewDataBinding
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

/**
 * Created by glebkalinichenko on 31.12.17.
 */
abstract class FragmentView<T> : Fragment() {
    lateinit var binding: ViewDataBinding
    var component: T? = null
    var errorDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = super.onCreateView(inflater, container, savedInstanceState)
        injectDependencies(getActivityComponent()!!)
        binding = DataBindingUtil.inflate(inflater, getLayoutId(), container,false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setVariables()
    }

    protected fun getActivityComponent(): T? {
        if (null != component) {
            return component
        }
        val retainedObject = activity!!.getLastCustomNonConfigurationInstance()
        if (retainedObject != null) {
            component = retainedObject as T
        } else {
            component = createComponent()
        }
        return component
    }

    override fun onDestroyView() {
        disposeErrorDisposables()
        super.onDestroyView()
    }

    internal fun disposeErrorDisposables() {
        if (!errorDisposable.isDisposed) errorDisposable.dispose()
    }

    abstract fun injectDependencies(component: T)

    abstract fun createComponent(): T

    abstract fun setVariables()

    abstract fun getLayoutId() : Int
}