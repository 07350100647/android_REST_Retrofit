package br.com.denio.androidproject02

import android.app.Application
import android.content.Context

internal class MainApplication: Application() {
    init {
        instance = this
    }


    companion object {
        private var instance: MainApplication? = null

        fun getApplicationContext(): Context {
            return instance!!.applicationContext
        }
    }
}