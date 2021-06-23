package com.example.android_pfti.di

import com.example.android_pfti.view.list_fragment.ListViewModel
import com.example.android_pfti.view.maps_fragment.MapsViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val MapsFragmentModule = module {
    viewModel { MapsViewModel() }
}

val ListFragmentModule = module {
    viewModel { ListViewModel() }
}