package com.example.fitnext_app


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast



class HOME : AppCompatActivity() {

    private var backPressedTime = 0L

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)



        //setting button
        val setting = findViewById<ImageView>(R.id.imageView2)
        setting.setOnClickListener {
            //call setting
            val intent = Intent(this, Setting::class.java)
            startActivity(intent)
        }


//button from exercise xml
        val exercise = findViewById<Button>(R.id.exercise)
        exercise.setOnClickListener {
            //call exercise activity
            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
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



