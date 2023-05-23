package com.mivanovskaya.ktorkmm

interface Platform {
    val nameWithVersion: String
    val name: String
}

expect fun getPlatform(): Platform