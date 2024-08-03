package com.example.shoppish

import android.app.Application
import com.google.firebase.FirebaseApp

class ShoppishApp : Application() {
    override fun onCreate() {
        super.onCreate()

        FirebaseApp.initializeApp(this)
    }

}