package com.example.fitnext_app.bodyparts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fitnext_app.ExerciseActivity
import com.example.fitnext_app.R
import com.example.fitnext_app.bodyparts.shoulderdifficulty.shoulderAdvance
import com.example.fitnext_app.bodyparts.shoulderdifficulty.shoulderIntermediate
import com.example.fitnext_app.bodyparts.shoulderdifficulty.shoulderbeginner
import com.example.fitnext_app.databinding.ActivityShoulderExBinding

class ShoulderEx : AppCompatActivity() {

    private lateinit var binding: ActivityShoulderExBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shoulder_ex)

        binding = ActivityShoulderExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.beginner.setOnClickListener {

            replaceFragment(shoulderbeginner())

        }

        binding.intermediate.setOnClickListener {

            replaceFragment(shoulderIntermediate())

        }
        binding.advance.setOnClickListener {

            replaceFragment(shoulderAdvance())

        }


        //call exercises
        val shoulder = findViewById<ImageView>(R.id.shoulderarrow)
        shoulder.setOnClickListener {

            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)

        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()


    }
}
