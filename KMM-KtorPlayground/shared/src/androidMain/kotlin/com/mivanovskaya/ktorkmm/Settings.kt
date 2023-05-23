package com.mivanovskaya.ktorkmm

import android.content.Context
import com.russhwolf.settings.Settings
import com.russhwolf.settings.SharedPreferencesSettings

var appContext: Context? = null

actual fun getSettings(): Settings {
    val delegate = appContext!!.getSharedPreferences("platform_name_key", Context.MODE_PRIVATE)
    return SharedPreferencesSettings(delegate)
}