package com.example.android_pfti

import com.google.android.gms.maps.model.LatLng

object LocationList {

    var arrayOfMarkers = mutableListOf<Pair<LatLng, String>>(
        Pair<LatLng, String>(LatLng(93.0, 151.0), "First"),
        Pair<LatLng, String>(LatLng(54.0, 82.0), "Second"),
        Pair<LatLng, String>(LatLng(-34.0, 151.0), "Third")
    )
}