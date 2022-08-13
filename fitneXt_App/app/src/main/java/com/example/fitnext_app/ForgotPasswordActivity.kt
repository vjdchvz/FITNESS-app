package com.example.fitnext_app
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import com.example.fitnext_app.databinding.ActivityForgotPasswordBinding
import com.google.firebase.auth.FirebaseAuth


class ForgotPasswordActivity : AppCompatActivity() {

    private lateinit var binding: ActivityForgotPasswordBinding
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        binding = ActivityForgotPasswordBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()

        //back to login button
        val setting = findViewById<ImageView>(R.id.arrow3)
        setting.setOnClickListener {
            //call login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.fade_out)
        }


        binding.submit.setOnClickListener {
            val email = binding.forgot.text.toString()
            if (email.isNotEmpty()) {

                firebaseAuth.sendPasswordResetEmail(email).addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Email Sent!!", Toast.LENGTH_SHORT).show()
                        overridePendingTransition(android.R.anim.cycle_interpolator,android.R.anim.fade_out)
                        finish()
                    }
                    else
                    {
                        Toast.makeText(this, "Invalid Email Address ", Toast.LENGTH_SHORT).show()

                    }

                }
            }
            else
            {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT).show()

            }

      }

        }

    }





