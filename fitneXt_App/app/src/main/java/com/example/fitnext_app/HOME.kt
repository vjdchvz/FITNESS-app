package com.example.fitnext_app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class HOME : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        //receive  input
        val inputValue = intent.getStringExtra("User")
        //display  input
        findViewById<TextView>(R.id.hometext).apply {
            text = inputValue

        }
    }
}