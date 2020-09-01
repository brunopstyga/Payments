package com.example.payment.presentation

import android.content.SharedPreferences
import com.example.payment.data.di.modulo.SharePreferences
import javax.inject.Inject

class MySharePreferences @Inject constructor(val mySharePreferences: SharedPreferences) {
    fun putData(key : String , data: String) = mySharePreferences.edit().putString(key , data).apply()
    fun getData(key: String) : Int = mySharePreferences.getInt(key, 0)
    fun putAmount(key : String , amount : Int) = mySharePreferences.edit().putInt(key, amount).apply()
    fun getAmount(key: String) : Int = mySharePreferences.getInt(key, 0)
}