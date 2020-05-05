package com.karan.myapplication.data

import android.util.Log
import com.karan.myapplication.di.ActivityScope
import javax.inject.Inject

@ActivityScope
class Repository @Inject constructor() {

    fun printInstance(){
        Log.e("repository", "$this")
    }
}