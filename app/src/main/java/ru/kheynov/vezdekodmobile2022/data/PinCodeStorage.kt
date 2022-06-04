package ru.kheynov.vezdekodmobile2022.data

import android.content.Context
import android.content.SharedPreferences

private const val PREFERENCES_NAME = "PIN_CODE"

private const val PIN_KEY = "pin_code"
private const val PIN_EXISTS_KEY = "pin_code_exists"

class PinCodeStorage(context: Context) {

    private val sharedPref: SharedPreferences =
        context.getSharedPreferences(PREFERENCES_NAME, Context.MODE_PRIVATE)

    fun save(value: String) {
        val editor: SharedPreferences.Editor = sharedPref.edit()
        editor.putBoolean(PIN_EXISTS_KEY, true)
        editor.putString(PIN_KEY, value)
        editor.apply()
    }

    fun getPin(): String {
        val pin = sharedPref.getString(PIN_KEY, "") ?: ""
        return pin
    }

    fun isPinExists(): Boolean {
        return sharedPref.getBoolean(PIN_EXISTS_KEY, false)
    }
}