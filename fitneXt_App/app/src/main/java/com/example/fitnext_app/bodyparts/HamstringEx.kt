package com.example.fitnext_app.bodyparts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fitnext_app.ExerciseActivity
import com.example.fitnext_app.R
import com.example.fitnext_app.bodyparts.hamstringdifficulty.hamstringAdvance
import com.example.fitnext_app.bodyparts.hamstringdifficulty.hamstringBeginner
import com.example.fitnext_app.bodyparts.hamstringdifficulty.hamstringIntermediate
import com.example.fitnext_app.databinding.ActivityHamstringExBinding


class HamstringEx : AppCompatActivity() {

    private lateinit var binding: ActivityHamstringExBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hamstring_ex)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
                hamstringBeginner()
            ).commit()
        }

        binding = ActivityHamstringExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.beginner.setOnClickListener {

            replaceFragment(hamstringBeginner())

        }

        binding.intermediate.setOnClickListener {

            replaceFragment(hamstringIntermediate())

        }
        binding.advance.setOnClickListener {

            replaceFragment(hamstringAdvance())

        }


        //call exercises
        val hamstring = findViewById<ImageView>(R.id.hamstringarrow)
        hamstring.setOnClickListener {

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
