package com.photo.mahsa

import android.app.Application
import com.photo.mahsa.di.AppContainer

class App: Application() {
    val appContainer = AppContainer()
}