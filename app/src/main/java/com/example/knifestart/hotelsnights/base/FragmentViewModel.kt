package com.example.knifestart.hotelsnights.base

import android.databinding.BaseObservable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.subjects.PublishSubject



/**
 * Created by glebkalinichenko on 01.01.18.
 */
open class FragmentViewModel constructor(var disposables: CompositeDisposable = CompositeDisposable()) : BaseObservable(), IFragmentBaseViewModel {
    var errorSubject = PublishSubject.create<String>()

    override fun onCreateView() {}

    override fun onStart() {}

    override fun onDestroyView() {
        dispose()
    }

    override fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }

    fun addDisposable(disposable: Disposable) = disposables.add(disposable)
}