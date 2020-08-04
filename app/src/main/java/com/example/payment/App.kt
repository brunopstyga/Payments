package com.example.pagos


import com.example.pagos.data.di.modulo.DaggerComponet
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<App?>? = DaggerComponet.factory().create(this)


}