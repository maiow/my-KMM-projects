package com.mivanovskaya.ktorkmm

import platform.UIKit.UIDevice

class IOSPlatform : Platform {
    override val nameWithVersion: String =
        UIDevice.currentDevice.systemName() + " " + UIDevice.currentDevice.systemVersion
    override val name: String = UIDevice.currentDevice.systemName()
}

actual fun getPlatform(): Platform = IOSPlatform()