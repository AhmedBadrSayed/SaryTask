package com.mondiamedia.ahmedbadr.sarytask

import android.app.Application
import com.mondiamedia.ahmedbadr.sarytask.di.module.appModule
import com.mondiamedia.ahmedbadr.sarytask.di.module.repoModule
import com.mondiamedia.ahmedbadr.sarytask.di.module.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(listOf(appModule, repoModule, viewModelModule))
        }
    }
}