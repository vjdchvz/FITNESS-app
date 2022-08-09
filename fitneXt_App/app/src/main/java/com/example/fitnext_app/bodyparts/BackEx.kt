package com.example.fitnext_app.bodyparts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fitnext_app.ExerciseActivity
import com.example.fitnext_app.R
import com.example.fitnext_app.bodyparts.backdifficulty.backAdvance
import com.example.fitnext_app.bodyparts.backdifficulty.backBeginner
import com.example.fitnext_app.bodyparts.backdifficulty.backIntermediate
import com.example.fitnext_app.databinding.ActivityBackExBinding

class BackEx : AppCompatActivity() {

    private lateinit var binding: ActivityBackExBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_back_ex)

        binding = ActivityBackExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
                backBeginner()
            ).commit()
        }

        binding.beginner.setOnClickListener {

            replaceFragment(backBeginner())

        }

        binding.intermediate.setOnClickListener {

            replaceFragment(backIntermediate())

        }
        binding.advance.setOnClickListener {

            replaceFragment(backAdvance())

        }


        //call exercises
        val back = findViewById<ImageView>(R.id.backarrow)
        back.setOnClickListener {

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
