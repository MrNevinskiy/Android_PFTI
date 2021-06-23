package com.example.android_pfti.model.repo

import com.google.android.gms.maps.model.LatLng

object LocationList {

    var arrayOfMarkers = mutableListOf(
        Pair(LatLng(93.0, 151.0), "First"),
        Pair(LatLng(54.0, 82.0), "Second"),
        Pair(LatLng(-34.0, 151.0), "Third")
    )
}