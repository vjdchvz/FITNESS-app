package com.example.fitnext_app.bodyparts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fitnext_app.ExerciseActivity
import com.example.fitnext_app.R
import com.example.fitnext_app.bodyparts.tricepsdifficulty.tricepsAdvance
import com.example.fitnext_app.bodyparts.tricepsdifficulty.tricepsBeginner
import com.example.fitnext_app.bodyparts.tricepsdifficulty.tricepsIntermediate
import com.example.fitnext_app.databinding.ActivityTricepsExBinding

class TricepsEx : AppCompatActivity() {

    private lateinit var binding: ActivityTricepsExBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_triceps_ex)

        binding = ActivityTricepsExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
                tricepsBeginner()
            ).commit()
        }

        binding.beginner.setOnClickListener {

            replaceFragment(tricepsBeginner())

        }

        binding.intermediate.setOnClickListener {

            replaceFragment(tricepsIntermediate())

        }
        binding.advance.setOnClickListener {

            replaceFragment(tricepsAdvance())

        }


        //call exercises
        val triceps = findViewById<ImageView>(R.id.tricepsarrow)
        triceps.setOnClickListener {

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