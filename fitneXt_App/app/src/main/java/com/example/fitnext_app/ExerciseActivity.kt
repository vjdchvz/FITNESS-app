package com.example.fitnext_app


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.example.fitnext_app.bodyparts.*


class ExerciseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_exercise)
//back to home button
        val setting = findViewById<ImageView>(R.id.arrow2)
        setting.setOnClickListener {
            //call home
            val intent = Intent(this, Dashboard::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.fade_out)
        }
        //call hamstring
        val hams = findViewById<Button>(R.id.ham)
        hams.setOnClickListener {

            val intent = Intent(this, HamstringEx::class.java)
            startActivity(intent)
        }
        //call calves
        val cals = findViewById<Button>(R.id.cal)
        cals.setOnClickListener {

            val intent = Intent(this, CalvesEx::class.java)
            startActivity(intent)
        }
        //call chest
        val ches = findViewById<Button>(R.id.che)
        ches.setOnClickListener {

            val intent = Intent(this, ChestEx::class.java)
            startActivity(intent)
        }
        //call back
        val bac = findViewById<Button>(R.id.back)
        bac.setOnClickListener {

            val intent = Intent(this, BackEx::class.java)
            startActivity(intent)
        }
        //call shoulder
        val sho = findViewById<Button>(R.id.shou)
        sho.setOnClickListener {

            val intent = Intent(this, ShoulderEx::class.java)
            startActivity(intent)
        }
        //call triceps
        val trice = findViewById<Button>(R.id.tri)
        trice.setOnClickListener {

            val intent = Intent(this, TricepsEx::class.java)
            startActivity(intent)
        }
        //call biceps
        val bicep = findViewById<Button>(R.id.bic)
        bicep.setOnClickListener {

            val intent = Intent(this, BicepsEx::class.java)
            startActivity(intent)
        }
        //call forearms
        val arm = findViewById<Button>(R.id.fore)
        arm.setOnClickListener {

            val intent = Intent(this, ForeArmsEx::class.java)
            startActivity(intent)
        }
        //call abs
        val abss = findViewById<Button>(R.id.abs)
        abss.setOnClickListener {

            val intent = Intent(this, AbsEx::class.java)
            startActivity(intent)
        }
        }
    }

