package com.example.pagos.data.di.modulo

import android.app.Application
import android.content.Context
import com.example.pagos.App
import com.example.payment.data.di.modulo.SharePreferences
import dagger.Binds
import dagger.Module

@Module(includes = [
    PagoNetwork::class,
     SharePreferences::class
])

abstract class AppModule {
    @Binds
    abstract fun bindApplication(app: App?): Application?

    @Binds
    abstract fun bindContext(app: Application): Context
}