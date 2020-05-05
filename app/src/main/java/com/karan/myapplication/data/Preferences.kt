package com.karan.myapplication.data

import android.content.Context
import android.util.Log
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Preferences @Inject constructor(context: Context) {

    fun printInstance() {
        Log.e("preferences", "$this")
    }
}