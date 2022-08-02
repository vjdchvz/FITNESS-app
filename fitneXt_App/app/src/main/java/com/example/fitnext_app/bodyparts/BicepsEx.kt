package com.example.fitnext_app.bodyparts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.fitnext_app.ExerciseActivity
import com.example.fitnext_app.R

class BicepsEx : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biceps_ex)

        //call exercises
        val bic = findViewById<ImageView>(R.id.bicepsarrow)
        bic.setOnClickListener {

            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
        }
    }
}