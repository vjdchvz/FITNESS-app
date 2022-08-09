package com.example.fitnext_app.bodyparts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fitnext_app.ExerciseActivity
import com.example.fitnext_app.R
import com.example.fitnext_app.bodyparts.chestdifficulty.chestAdvance
import com.example.fitnext_app.bodyparts.chestdifficulty.chestBeginner
import com.example.fitnext_app.bodyparts.chestdifficulty.chestIntermediate
import com.example.fitnext_app.databinding.ActivityChestExBinding


class ChestEx : AppCompatActivity() {

    private lateinit var binding: ActivityChestExBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chest_ex)

        binding = ActivityChestExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(R.id.fragmentContainerView,
                chestBeginner()
            ).commit()
        }

        binding.beginner.setOnClickListener {

            replaceFragment(chestBeginner())

        }

        binding.intermediate.setOnClickListener {

            replaceFragment(chestIntermediate())

        }
        binding.advance.setOnClickListener {

            replaceFragment(chestAdvance())

        }


        //call exercises
        val chest = findViewById<ImageView>(R.id.chestarrow)
        chest.setOnClickListener {

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
