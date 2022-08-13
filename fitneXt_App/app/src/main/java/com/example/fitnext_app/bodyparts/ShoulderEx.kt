package com.example.fitnext_app.bodyparts
import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.fitnext_app.ExerciseActivity
import com.example.fitnext_app.bodyparts.shoulderdifficulty.shoulderAdvance
import com.example.fitnext_app.bodyparts.shoulderdifficulty.shoulderIntermediate
import com.example.fitnext_app.bodyparts.shoulderdifficulty.shoulderbeginner
import com.example.fitnext_app.databinding.ActivityShoulderExBinding


class ShoulderEx : AppCompatActivity() {

    private lateinit var binding: ActivityShoulderExBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.example.fitnext_app.R.layout.activity_shoulder_ex)

        binding = ActivityShoulderExBinding.inflate(layoutInflater)
        setContentView(binding.root)


        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().replace(com.example.fitnext_app.R.id.fragmentContainerView,
                shoulderbeginner()
            ).commit()
        }

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
        val shoulder = findViewById<ImageView>(com.example.fitnext_app.R.id.shoulderarrow)
        shoulder.setOnClickListener {

            val intent = Intent(this, ExerciseActivity::class.java)
            startActivity(intent)
            overridePendingTransition(android.R.anim.slide_in_left,android.R.anim.fade_out)

        }
    }

    private fun replaceFragment(fragment: Fragment) {

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(com.example.fitnext_app.R.id.fragmentContainerView, fragment)
        fragmentTransaction.commit()


    }
}
