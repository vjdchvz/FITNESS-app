package com.example.fitnext_app.bodyparts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import com.example.fitnext_app.ExerciseActivity
import com.example.fitnext_app.R

class TrapeziusEx : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trapezius_ex)

        //call exercises
        val trape = findViewById<ImageView>(R.id.trapeziusarrow)
        trape.setOnClickListener {

        val intent = Intent(this, ExerciseActivity::class.java)
        startActivity(intent)
    }
    }
}