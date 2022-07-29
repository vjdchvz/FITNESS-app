package com.example.fitnext_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class Setting : AppCompatActivity() {


    private lateinit var logout: Button
    private lateinit var firebaseAuth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        //don't forget the getInstance()
        firebaseAuth = FirebaseAuth.getInstance()


        //logout
        logout = findViewById(R.id.logout)
        logout.setOnClickListener {
            firebaseAuth.signOut()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()

            Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT)
                .show()
        }



        //exit button
        val exitButton = findViewById<View>(R.id.exit_btn) as Button
        exitButton.setOnClickListener {
            finishAffinity()

        }

        //back to home button
        val setting = findViewById<ImageView>(R.id.arrow)
        setting.setOnClickListener {
            //call home
            val intent = Intent(this, HOME::class.java)
            startActivity(intent)
        }

    }
    }
