package com.example.nytimes.util

import androidx.lifecycle.ProcessLifecycleOwnerInitializer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import java.lang.IllegalArgumentException

object ExtFunctions {
    inline fun <reified T :ViewModel> ViewModelStoreOwner.getViewModel(crossinline initializer: () -> T):T{
        val viewModelClass = T::class.java
        val  factory = object : ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                return when {
                    modelClass.isAssignableFrom(viewModelClass) -> initializer.invoke() as  T
                    else -> throw IllegalArgumentException("Unknown ViewModel Class")
                }
            }
        }
        return ViewModelProvider(this,factory).get(viewModelClass)
    }
}