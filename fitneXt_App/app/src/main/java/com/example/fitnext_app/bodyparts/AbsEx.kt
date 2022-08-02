package com.example.fitnext_app.bodyparts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.example.fitnext_app.ExerciseActivity
import com.example.fitnext_app.R
import com.example.fitnext_app.bodyparts.absdifficulty.absAdvance
import com.example.fitnext_app.bodyparts.absdifficulty.absBeginner
import com.example.fitnext_app.bodyparts.absdifficulty.absIntermediate
import com.example.fitnext_app.databinding.ActivityAbsExBinding

class AbsEx : AppCompatActivity() {
    private lateinit var binding: ActivityAbsExBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_abs_ex)

        binding = ActivityAbsExBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.beginner.setOnClickListener {

            replaceFragment(absBeginner())

        }

        binding.intermediate.setOnClickListener {

            replaceFragment(absIntermediate())

        }
        binding.advance.setOnClickListener {

            replaceFragment(absAdvance())

        }


        //call exercises
        val abs = findViewById<ImageView>(R.id.absarrow)
        abs.setOnClickListener {

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




