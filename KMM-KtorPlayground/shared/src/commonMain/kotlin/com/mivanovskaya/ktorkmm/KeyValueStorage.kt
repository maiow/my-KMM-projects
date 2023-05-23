package com.mivanovskaya.ktorkmm

import com.russhwolf.settings.Settings
import com.russhwolf.settings.nullableString

class KeyValueStorage(settings: Settings) {
    var platformName: String? by settings.nullableString("platform_name_key")
    var language: String? by settings.nullableString("language_key")
}

