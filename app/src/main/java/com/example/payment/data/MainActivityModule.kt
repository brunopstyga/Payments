package com.example.pagos.data

import com.example.pagos.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity

//    @ContributesAndroidInjector
//    abstract fun bindResultsFragment(): ListFragment

//    @ContributesAndroidInjector
//    abstract fun bindDetailFragment(): DetailFragment
}