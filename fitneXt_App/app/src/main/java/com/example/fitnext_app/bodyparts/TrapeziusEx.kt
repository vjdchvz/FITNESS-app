package com.example.fitnext_app.bodyparts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fitnext_app.ExerciseActivity
import com.example.fitnext_app.R
import com.example.fitnext_app.bodyparts.trapeziusdifficulty.trapeziusAdvance
import com.example.fitnext_app.bodyparts.trapeziusdifficulty.trapeziusBeginner
import com.example.fitnext_app.bodyparts.trapeziusdifficulty.trapeziusIntermediate
import com.example.fitnext_app.databinding.ActivityTrapeziusExBinding


class TrapeziusEx : AppCompatActivity() {

    private lateinit var binding: ActivityTrapeziusExBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trapezius_ex)
        binding = ActivityTrapeziusExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.beginner.setOnClickListener {

            replaceFragment(trapeziusBeginner())

        }

        binding.intermediate.setOnClickListener {

            replaceFragment(trapeziusIntermediate())

        }
        binding.advance.setOnClickListener {

            replaceFragment(trapeziusAdvance())

        }


        //call exercises
        val trapezius = findViewById<ImageView>(R.id.trapeziusarrow)
        trapezius.setOnClickListener {

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
