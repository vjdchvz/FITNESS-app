package com.example.fitnext_app


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth


class HOME : AppCompatActivity() {

    private lateinit var logout: Button
    private lateinit var firebaseAuth: FirebaseAuth
    private var backPressedTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
   //don't forget the getInstance()
        firebaseAuth = FirebaseAuth.getInstance()


        //logout
        logout = findViewById(R.id.logout)
        logout.setOnClickListener {
            firebaseAuth.signOut()

            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            Toast.makeText(this, "Logout Successfully", Toast.LENGTH_SHORT)
                .show()
        }


        //exit button
        val exitButton = findViewById<View>(R.id.exit_btn) as Button
        exitButton.setOnClickListener {
            finishAffinity()

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

