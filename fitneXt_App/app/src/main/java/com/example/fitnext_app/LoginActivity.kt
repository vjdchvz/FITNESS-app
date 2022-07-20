package com.example.fitnext_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        var Username = findViewById<EditText>(R.id.Username)
        var Password = findViewById<EditText>(R.id.Password)
        var button3 = findViewById<Button>(R.id.button3)


        // set on-click listener
        button3.setOnClickListener {
            val name = Username.text;
            val pass = Password.text;
            Toast.makeText(this@LoginActivity, name, Toast.LENGTH_LONG).show()

            // your code to validate the user_name and password combination
            // and verify the same

        }
        }

    }
