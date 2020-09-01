package com.example.pagos.data.di.modulo

import com.example.pagos.App
import com.example.pagos.data.MainActivityModule
import com.example.payment.data.di.modulo.SharePreferences
import com.example.practicaskotlin.data.model.factory.ViewModelBuilder
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        AndroidSupportInjectionModule::class,
        ViewModelBuilder::class,
        MainActivityModule::class
]
)

interface Componet : AndroidInjector<App>{

    @Component.Factory
    abstract class Factory : AndroidInjector.Factory<App?>

}