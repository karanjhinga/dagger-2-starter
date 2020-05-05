package com.karan.myapplication.data

import android.util.Log
import com.karan.myapplication.di.FragmentScope
import javax.inject.Inject

@FragmentScope
class User @Inject constructor() {

    fun printInstance() {
        Log.e("tag", "$this")
    }
}