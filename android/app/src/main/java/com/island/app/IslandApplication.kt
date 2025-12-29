package com.island.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class IslandApplication : Application() {
    
    override fun onCreate() {
        super.onCreate()
    }
}
