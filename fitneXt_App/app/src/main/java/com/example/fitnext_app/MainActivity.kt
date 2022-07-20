package com.example.fitnext_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //button for get pump
        val button = findViewById<Button>(R.id.homebutton)
        button.setOnClickListener {
            //call page 2
            val page2 = Intent(this, MainActivity2::class.java)
            startActivity(page2)
        }
    }
}