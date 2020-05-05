package com.karan.myapplication

import android.app.Application
import com.karan.myapplication.di.AppComponent
import com.karan.myapplication.di.DaggerAppComponent

class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(this)
    }
}