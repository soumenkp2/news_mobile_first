package com.example.news_mobile_first

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.airbnb.lottie.LottieAnimationView

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val lottieAnimationView: LottieAnimationView = findViewById(R.id.lottieAnimationView)

        lottieAnimationView.playAnimation()

        // After animation finishes, navigate to the next screen
        lottieAnimationView.addAnimatorUpdateListener {
            if (it.animatedFraction == 1f) {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}