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
            val inputValue = intent.getStringExtra("email")
        //override the data received


            //display  input for welcome
            findViewById<TextView>(R.id.welcome).apply {
                text = inputValue
            }

                //GO HOME BUTTON
                val toHomeButton = findViewById<Button>(R.id.homebutton)
                toHomeButton.setOnClickListener {
                    //call page 6
                    val intent = Intent(this@LoginActivity2,HOME::class.java)
                    intent.putExtra("email",inputValue)
                    startActivity(intent)




            }
        }
    }

