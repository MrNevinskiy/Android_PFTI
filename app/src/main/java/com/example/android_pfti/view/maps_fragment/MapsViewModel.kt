package com.example.android_pfti.view.maps_fragment

import androidx.lifecycle.LiveData
import com.example.android_pfti.model.AppData
import com.example.android_pfti.model.repo.LocationList
import com.example.android_pfti.view.activity.BaseViewModel
import com.google.android.gms.maps.model.LatLng

class MapsViewModel : BaseViewModel<AppData>() {

    fun subscribe(): LiveData<AppData> = liveDataViewModel

    fun setMarker(pair: Pair<LatLng,String>){
        LocationList.arrayOfMarkers.add(pair)
    }

    fun getListOfMarker(){
        liveDataViewModel.value = AppData.Success(LocationList)
    }

    override fun errorReturned(t: Throwable) {
        println(t.message.toString())
    }
}