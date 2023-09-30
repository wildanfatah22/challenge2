package com.example.challenge2.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView
import android.widget.TextView
import com.example.challenge2.R
import com.example.challenge2.databinding.ActivitySplashScreenBinding

class SplashScreenActivity : AppCompatActivity() {
    private lateinit var topAnimation: Animation
    private lateinit var bottomAnimation: Animation
    private lateinit var imageIcon: ImageView
    private lateinit var imageLogo: TextView
    private lateinit var slogan: TextView

    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )

        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, 3000)

        topAnimation = AnimationUtils.loadAnimation(this, R.anim.top_animation)
        bottomAnimation = AnimationUtils.loadAnimation(this, R.anim.bottom_animation)

        imageIcon = binding.icon
        imageLogo = binding.iconText
        slogan = binding.sloganText

        imageIcon.startAnimation(topAnimation)
        imageLogo.startAnimation(bottomAnimation)
        slogan.startAnimation(bottomAnimation)
    }
}