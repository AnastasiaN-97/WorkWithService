package com.example.workwithservice

import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.util.Log


class MyService : Service() {

    private val LOG_TAG = "myLogs"
    val mainHandler = Handler(Looper.getMainLooper())

    override fun onCreate() {
        super.onCreate()
        Log.d(LOG_TAG, "onCreate")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(LOG_TAG, "onStartCommand")

        mainHandler.post(object : Runnable {
            override fun run() {
                random()
                mainHandler.postDelayed(this, 5000)
            }
        })
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onDestroy() {
        super.onDestroy()
        mainHandler.removeCallbacksAndMessages(null)
        Log.d(LOG_TAG, "onDestroy")
    }

    override fun onBind(intent: Intent?): IBinder? {
        Log.d(LOG_TAG, "onBind")
        return null
    }

    fun random() {
        val number = (Int.MIN_VALUE..Int.MAX_VALUE).random()
        Log.d(LOG_TAG, "$number")
    }
}