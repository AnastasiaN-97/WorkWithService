package com.example.workwithservice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startBtn: Button = findViewById(R.id.button)
        val stopBtn: Button = findViewById(R.id.button2)

        startBtn.setOnClickListener {
            startService(Intent(this, MyService::class.java))
        }

        stopBtn.setOnClickListener {
                stopService(Intent(this, MyService::class.java))
        }
    }




}