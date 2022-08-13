package com.example.fitnext_app

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.fitnext_app.databinding.ActivityOnboarding2Binding
import com.google.firebase.auth.FirebaseAuth


class Onboarding2 : AppCompatActivity() {

    private lateinit var binding: ActivityOnboarding2Binding
    private lateinit var firebaseAuth: FirebaseAuth

    //splash screen of main activity 2
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding2)

        //don't forget this binding
        binding = ActivityOnboarding2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        if (firebaseAuth.currentUser != null) {

            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
                //toast position
            val toast = Toast.makeText(this, "WELCOME BACK!", Toast.LENGTH_LONG)
            toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0)
            toast.show()

        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent2 = Intent(this, LoginActivity::class.java)
                startActivity(intent2)
                overridePendingTransition(android.R.anim.bounce_interpolator,android.R.anim.bounce_interpolator)

                // to get rid of this when u push the back button
                finish()
            }, 5000)


        }

    }
}


