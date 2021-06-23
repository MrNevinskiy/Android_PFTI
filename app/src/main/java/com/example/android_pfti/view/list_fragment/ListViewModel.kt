package com.example.android_pfti.view.list_fragment

import androidx.lifecycle.LiveData
import com.example.android_pfti.model.AppData
import com.example.android_pfti.model.repo.LocationList
import com.example.android_pfti.view.activity.BaseViewModel

class ListViewModel: BaseViewModel<AppData>()  {

    fun subscribe(): LiveData<AppData> = liveDataViewModel

    fun getListOfMarker(){
        liveDataViewModel.value = AppData.Success(LocationList)
    }

    override fun errorReturned(t: Throwable) {
        println(t.message.toString())
    }
}