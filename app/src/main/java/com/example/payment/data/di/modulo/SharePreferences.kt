package com.example.payment.data.di.modulo

import android.content.Context
import android.content.SharedPreferences
import com.example.pagos.presentation.Util
import dagger.Module
import dagger.Provides

@Module
class SharePreferences {
    @Provides
    fun provideSharedPreferences(context: Context) : SharedPreferences =
        context.getSharedPreferences(Util.SP_FILE, Context.MODE_PRIVATE)
}