package com.example.android_pfti.view.activity

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android_pfti.model.AppData
import kotlinx.coroutines.*

abstract class BaseViewModel<T : AppData>(
    protected val liveDataViewModel: MutableLiveData<T> = MutableLiveData()
) : ViewModel() {

    private val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            errorReturned(throwable)
        })

    private fun cancelJob() {
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }

    override fun onCleared() {
        super.onCleared()
        cancelJob()
    }

    abstract fun errorReturned(t: Throwable)
}