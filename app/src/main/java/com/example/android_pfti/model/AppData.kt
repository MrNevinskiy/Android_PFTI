package com.example.android_pfti.model

sealed class AppData {
    data class Success<out T>(val data: T): AppData()
    data class Error(val error: Throwable): AppData()
}