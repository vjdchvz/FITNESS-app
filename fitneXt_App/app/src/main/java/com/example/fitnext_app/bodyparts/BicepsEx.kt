package com.example.fitnext_app.bodyparts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fitnext_app.ExerciseActivity
import com.example.fitnext_app.R
import com.example.fitnext_app.bodyparts.bicepsdifficulty.bicepsAdvance
import com.example.fitnext_app.bodyparts.bicepsdifficulty.bicepsBeginner
import com.example.fitnext_app.bodyparts.bicepsdifficulty.bicepsIntermediate
import com.example.fitnext_app.databinding.ActivityBicepsExBinding

class BicepsEx : AppCompatActivity() {

    private lateinit var binding: ActivityBicepsExBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biceps_ex)

        binding = ActivityBicepsExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
               bicepsBeginner()
            ).commit()
        }

        binding.beginner.setOnClickListener {

            replaceFragment(bicepsBeginner())

        }

        binding.intermediate.setOnClickListener {

            replaceFragment(bicepsIntermediate())

        }
        binding.advance.setOnClickListener {

            replaceFragment(bicepsAdvance())

        }


        //call exercises
        val biceps = findViewById<ImageView>(R.id.bicepsarrow)
        biceps.setOnClickListener {

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
