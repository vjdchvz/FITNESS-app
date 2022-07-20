package com.example.fitnext_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.core.content.ContextCompat.startActivity


class LoginActivity : AppCompatActivity()  {


    override fun onCreate(savedInstanceState: Bundle?) {



        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val button3 = findViewById<Button>(R.id.button3)

        button3.setOnClickListener {
           //call the function check
            check()
        }
    }

    private fun check() {
        val inputting = findViewById<EditText>(R.id.userName)
        val impasse = findViewById<EditText>(R.id.passWord)

       //receive user input
        val inputValue: String = inputting.text.toString()

        //login conditions
        if( impasse.text.toString() == "admin"){
        //to proceed to next page
            val page4 = Intent(this, LoginActivity2::class.java)
            startActivity(page4)

            //display user input
            val intent = Intent(this@LoginActivity,LoginActivity2::class.java)
            intent.putExtra("Username", "Welcome! $inputValue")
            startActivity(intent)
        }
        else
        {
            Toast.makeText(this,"Login Failed", Toast.LENGTH_LONG).show()

        }
    }
}


