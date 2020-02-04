package com.jy.fragment_bottmnavigation

import android.app.Application
import com.google.firebase.FirebaseApp

class BtmApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        FirebaseApp.initializeApp(this)
    }
}