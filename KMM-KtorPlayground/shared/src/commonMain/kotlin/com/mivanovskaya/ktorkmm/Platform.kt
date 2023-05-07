package com.mivanovskaya.ktorkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform