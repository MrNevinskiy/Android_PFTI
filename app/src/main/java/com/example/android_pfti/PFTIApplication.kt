package com.example.android_pfti

import android.app.Application
import com.example.android_pfti.di.ListFragmentModule
import com.example.android_pfti.di.MapsFragmentModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class PFTIApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(applicationContext)
            modules(
                listOf(
                    MapsFragmentModule,
                    ListFragmentModule
                )
            )
        }
    }
}