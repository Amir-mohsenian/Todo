package com.photo.mahsa

import android.app.Application
import com.photo.mahsa.di.AppContainer

class App: Application() {
    lateinit var appContainer: AppContainer
    override fun onCreate() {
        super.onCreate()
        appContainer = AppContainer(applicationContext)
    }
}