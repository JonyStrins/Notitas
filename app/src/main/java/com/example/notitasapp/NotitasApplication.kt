package com.example.notitasapp

import android.app.Application
import com.example.notitasapp.data.DefaultAppContainer

class NotitasApplication: Application (){
    lateinit var container: DefaultAppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}