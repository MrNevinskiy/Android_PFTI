package com.example.android_pfti.view.maps_fragment

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.Fragment
import com.example.android_pfti.R
import com.example.android_pfti.databinding.FragmentMapsBinding
import com.example.android_pfti.model.AppData
import com.example.android_pfti.model.repo.LocationList
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.viewModel


class MapsFragment : Fragment(R.layout.fragment_maps), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: FragmentMapsBinding
    private val viewModel: MapsViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMapsBinding.bind(view)
        val mapFragment = childFragmentManager.findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
        viewModel.subscribe().observe(viewLifecycleOwner,{
            renderData(it)
        })
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        if (locationEnable()) return
        viewModel.getListOfMarker()
        mMap.setOnMapLongClickListener {
            mMap.addMarker(MarkerOptions().position(it).title("New marker"))
            viewModel.setMarker(Pair(it, "New marker"))
        }
    }

    private fun locationEnable(): Boolean {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED &&
            ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            return true
        }

        mMap.isMyLocationEnabled = true

        return false
    }

    private fun renderData(data: AppData) {
        when(data){
            is AppData.Success<*> -> {
                when(data.data){
                    is LocationList -> {
                        data.data.arrayOfMarkers.forEach{ marker: Pair<LatLng, String> ->
                            mMap.addMarker(MarkerOptions().position(marker.first).title(marker.second))
                        }
                    }
                }

            }
            else -> {
                Toast.makeText(context,"ErrorData", Toast.LENGTH_LONG).show()
            }
        }
    }

}