package com.example.fitnext_app.bodyparts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fitnext_app.ExerciseActivity
import com.example.fitnext_app.R
import com.example.fitnext_app.bodyparts.calvesdifficulty.calvesAdvance
import com.example.fitnext_app.bodyparts.calvesdifficulty.calvesBeginner
import com.example.fitnext_app.bodyparts.calvesdifficulty.calvesIntermediate
import com.example.fitnext_app.databinding.ActivityCalvesExBinding

class CalvesEx : AppCompatActivity() {

    private lateinit var binding: ActivityCalvesExBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calves_ex)

        binding =ActivityCalvesExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.beginner.setOnClickListener {

            replaceFragment(calvesBeginner())

        }

        binding.intermediate.setOnClickListener {

            replaceFragment(calvesIntermediate())

        }
        binding.advance.setOnClickListener {

            replaceFragment(calvesAdvance())

        }


        //call exercises
        val calves = findViewById<ImageView>(R.id.calvesarrow)
        calves.setOnClickListener {

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
