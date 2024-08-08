package com.example.cognizantrever

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class MyService : Service() {
    var TAG = MyService::class.java.simpleName

    override fun onCreate() {
        super.onCreate()
        Log.i(TAG,"my service created")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        super.onStartCommand(intent, flags, startId)
        Log.i(TAG,"my service started")

        return START_STICKY

    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG,"my service destroyed")

    }

    override fun onBind(intent: Intent): IBinder {
        TODO("Return the communication channel to the service.")
    }
}