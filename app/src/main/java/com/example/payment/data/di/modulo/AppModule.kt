package com.example.pagos.data.di.modulo

import android.app.Application
import com.example.pagos.App
import dagger.Binds
import dagger.Module

@Module(includes = [
    GeoNetwork::class
])

abstract class AppModule {
    @Binds
    abstract fun bindApplication(app: App?): Application?
}