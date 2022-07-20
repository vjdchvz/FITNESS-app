package com.example.fitnext_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class LoginActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)


            //receive  input
            val inputValue = intent.getStringExtra("Username")

            //display  input
            findViewById<TextView>(R.id.welcome).apply {
                text = inputValue
            }
                //GO HOME BUTTON
                val toHomeButton = findViewById<Button>(R.id.homebutton)
                toHomeButton.setOnClickListener {
                    //call page 5
                    val page5 = Intent(this, HOME::class.java)
                    startActivity(page5)

            }
        }
    }

