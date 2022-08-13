package com.example.fitnext_app.bodyparts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fitnext_app.ExerciseActivity
import com.example.fitnext_app.R
import com.example.fitnext_app.bodyparts.forearmsdifficulty.forearmsAdvance
import com.example.fitnext_app.bodyparts.forearmsdifficulty.forearmsBeginner
import com.example.fitnext_app.bodyparts.forearmsdifficulty.forearmsIntermediate
import com.example.fitnext_app.databinding.ActivityForeArmsExBinding

class ForeArmsEx : AppCompatActivity() {

    private lateinit var binding: ActivityForeArmsExBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fore_arms_ex)

        binding = ActivityForeArmsExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
                forearmsBeginner()
            ).commit()
        }

        binding.beginner.setOnClickListener {

            replaceFragment(forearmsBeginner())

        }

        binding.intermediate.setOnClickListener {

            replaceFragment(forearmsIntermediate())

        }
        binding.advance.setOnClickListener {

            replaceFragment(forearmsAdvance())

        }


        //call exercises
        val forearms = findViewById<ImageView>(R.id.forearmsarrow)
        forearms.setOnClickListener {

            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.fade_out)

        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()


    }
}
