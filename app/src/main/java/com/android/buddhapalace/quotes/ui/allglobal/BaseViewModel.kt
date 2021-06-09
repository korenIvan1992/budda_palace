package com.android.buddhapalace.quotes.ui.allglobal

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.core.extensions.default

abstract class BaseViewModel<S : Any>(defaultState: S) : ViewModel() {

    // Init state and set default value
    val state = MutableLiveData<S>().default(initialValue = defaultState)

}