package com.karan.myapplication.di

import android.util.Log
import com.karan.myapplication.LoginFragment
import com.karan.myapplication.data.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [LoginModule::class])
interface LoginComponent {
    @Subcomponent.Factory
    interface Factory {
        fun create(): LoginComponent
    }

    fun inject(fragment: LoginFragment)
}

@Module
class LoginModule {

    @Provides
    @FragmentScope
    fun providesFirebaseAuth(): FirebaseAuth {
        return object : FirebaseAuth {
            override fun printInstance() {
                Log.e("firebase", "$this")
            }
        }
    }
}