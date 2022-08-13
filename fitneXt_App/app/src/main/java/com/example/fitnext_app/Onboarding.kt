package com.example.fitnext_app

import android.content.Intent
import android.graphics.Color
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager
import android.widget.VideoView


class Onboarding : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        requestWindowFeature(1)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        window.statusBarColor = Color.TRANSPARENT
        setContentView(R.layout.activity_onboarding)

        val videoView: VideoView = findViewById(R.id.sheesh)

        val path = "android.resource://" + packageName + "/" + R.raw.splash
        val uri = Uri.parse(path)
        videoView.setVideoURI(uri)
        videoView.start()

        videoView.setOnCompletionListener {
            //timer
            Handler(Looper.getMainLooper()).postDelayed({
                startActivity(Intent(this, Onboarding2::class.java))
                overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
                // to get rid of this when u push the back button
                finish()
            }, 80)
        }
    }
}

