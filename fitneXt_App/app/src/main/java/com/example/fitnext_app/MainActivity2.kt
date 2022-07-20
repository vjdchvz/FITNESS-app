package com.example.fitnext_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //button to sign up
        val button2 = findViewById<Button>(R.id.button2)
        button2.setOnClickListener {
            //call page 3
            val page3 = Intent(this, LoginActivity::class.java)
            startActivity(page3)
        }
    }
}