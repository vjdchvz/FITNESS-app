package com.example.fitnext_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.Gravity
import android.widget.Toast
import com.example.fitnext_app.databinding.ActivityMain2Binding
import com.google.firebase.auth.FirebaseAuth


class MainActivity2 : AppCompatActivity() {

    private lateinit var binding: ActivityMain2Binding
    private lateinit var firebaseAuth: FirebaseAuth

    //splash screen of main activity 2
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //don't forget this binding
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        if (firebaseAuth.currentUser != null) {

            val intent = Intent(this, HOME::class.java)
            startActivity(intent)

            val toastposition = Toast.makeText(this, "Welcome Back!!", Toast.LENGTH_SHORT)
            //TOAST POSITION
            toastposition.setGravity(Gravity.CENTER,0,0)
                toastposition.show()
        } else {
            Handler(Looper.getMainLooper()).postDelayed({
                val intent2 = Intent(this, LoginActivity::class.java)
                startActivity(intent2)


                // to get rid of this when u push the back button
                finish()
            }, 10000)


        }

    }
}


