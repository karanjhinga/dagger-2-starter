package com.karan.myapplication.di

import com.karan.myapplication.ProfileFragment
import dagger.Subcomponent

@FragmentScope
@Subcomponent
interface ProfileComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): ProfileComponent
    }

    fun inject(fragment: ProfileFragment)
}