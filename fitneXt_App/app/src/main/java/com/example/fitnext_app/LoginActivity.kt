package com.example.fitnext_app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.fitnext_app.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth


class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var firebaseAuth: FirebaseAuth
    private var backPressedTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)


        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        firebaseAuth = FirebaseAuth.getInstance()
        // to sign  up
        binding.textView15.setOnClickListener {
            val intent = Intent(this, SignUp::class.java)
            startActivity(intent)
        }
        //forgot password
        binding.textView17.setOnClickListener {
            val intent = Intent(this, ForgotPasswordActivity::class.java)
            startActivity(intent)
        }


//login conditions
        binding.button3.setOnClickListener {
            val email = binding.l1.text.toString()
            val pass = binding.l2.text.toString()


            if (email.isNotEmpty() && pass.isNotEmpty()) {

                firebaseAuth.signInWithEmailAndPassword(email, pass).addOnCompleteListener {
                    if (it.isSuccessful) {
                        val intent = Intent(this, LoginActivity2::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(
                            this,
                            "Email or Password is Incorrect !! ",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }
            } else {
                Toast.makeText(this, "Empty Fields Are not Allowed !!", Toast.LENGTH_SHORT)
                    .show()

            }
        }
    }
    // for back press button
    override fun onBackPressed() {
        if (backPressedTime + 2000 > System.currentTimeMillis()){
            super.onBackPressed()
            finishAffinity()
        }else{
            Toast.makeText(applicationContext,"Press Back Again to Exit App",Toast.LENGTH_SHORT)
                .show()
        }
        backPressedTime = System.currentTimeMillis()
    }
    }









