package com.karan.myapplication.di

import com.karan.myapplication.MainActivity
import dagger.Subcomponent

@ActivityScope
@Subcomponent
interface ActivityComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ActivityComponent
    }

    fun inject(activity: MainActivity)

    fun loginComponent(): LoginComponent.Factory
    fun profileComponent(): ProfileComponent.Factory
}
