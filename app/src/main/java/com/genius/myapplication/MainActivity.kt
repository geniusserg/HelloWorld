package com.genius.myapplication

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private var helloView : TextView? = null
    private var counter : Int = 0
    private val text:String = "Hello, world!"
    private var active : Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        helloView = findViewById(R.id.helloText)
        helloView?.setText("")
        Thread {
            active = true
            while (active) {
                Thread.sleep(100)
                runOnUiThread {
                    if (counter < text.length) {
                        helloView?.setTextSize((20..30).random().toFloat())
                        helloView?.setTextColor((Color.BLACK..Color.WHITE).random())
                        helloView?.setText("${helloView?.text}${text[counter]}")
                        counter++
                    }
                    else {
                        helloView?.setText("")
                        counter = 0
                    }
                }
            }
        }.start()
    }
    override fun onDestroy(){
        super.onDestroy()
        active = false
    }
}