package com.mivanovskaya.ktorkmm

class AndroidPlatform : Platform {
    override val nameWithVersion: String = "Android ${android.os.Build.VERSION.SDK_INT}"
    override val name: String = "Android"
}

actual fun getPlatform(): Platform = AndroidPlatform()