package com.example.animationonsplashscreen

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AnimationUtils
import com.example.animationonsplashscreen.databinding.ActivitySplashScreenBinding

class SplashScreen : AppCompatActivity() {
    private lateinit var binding: ActivitySplashScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread({kotlin.run {

            var animation=AnimationUtils.loadAnimation(this,R.anim.blink)
            binding.imageView.startAnimation(animation)
            Thread.sleep(5000)
            startActivity(Intent(this,MainActivity::class.java))
        }}).start()


    }
}