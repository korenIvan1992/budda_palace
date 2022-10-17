package com.android.core.extensions

import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

object NavigationExt  {

    fun <T> Fragment.getNavigationResult(key: String = "result") =
        findNavController().currentBackStackEntry?.savedStateHandle?.get<T>(key)

    fun <T> Fragment.getNavigationResultLiveData(key: String = "result") =
        findNavController().currentBackStackEntry?.savedStateHandle?.getLiveData<T>(key)

    fun <T> Fragment.setNavigationResult(result: T, key: String = "result") {
        findNavController().previousBackStackEntry?.savedStateHandle?.set(key, result)
    }
}