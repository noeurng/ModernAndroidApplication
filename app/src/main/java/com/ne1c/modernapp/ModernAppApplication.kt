package com.ne1c.modernapp

import android.app.Application
import com.ne1c.modernapp.di.mainModule
import com.ne1c.modernapp.di.networkModule
import org.koin.android.ext.android.startKoin

class ModernAppApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(networkModule, mainModule))
    }
}