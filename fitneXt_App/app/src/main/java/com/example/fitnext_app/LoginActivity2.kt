package com.example.fitnext_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper


class LoginActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login2)

        Handler(Looper.getMainLooper()).postDelayed({
            val intent = Intent(this, HOME::class.java)
            startActivity(intent)
            // to get rid of this when u push the back button
            finish()
        }

            ,3000 )


            }
        }


