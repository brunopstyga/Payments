package com.example.pagos.data

import com.example.pagos.MainActivity
import com.example.payment.presentation.InstallmentFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivityModule {

    @ContributesAndroidInjector
    abstract fun bindMainActivity() : MainActivity

    @ContributesAndroidInjector
    abstract fun bindInstallmentFragment(): InstallmentFragment

//    @ContributesAndroidInjector
//    abstract fun bindDetailFragment(): DetailFragment
}