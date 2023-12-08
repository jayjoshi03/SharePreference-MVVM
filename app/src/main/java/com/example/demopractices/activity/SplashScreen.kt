package com.example.demopractices.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.demopractices.databinding.ActivitySplashScreenBinding
import com.example.demopractices.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@SuppressLint("CustomSplashScreen")
class SplashScreen : AppCompatActivity() {
    private lateinit var binding : ActivitySplashScreenBinding
    private val viewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        Thread(Runnable {
            Thread.sleep(3000)
            val status = viewModel.getLoginStatus()

            if(status) {
                //Navigate to Home Screen
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else
            //Navigate to Login Screen
                startActivity(Intent(this, LoginActivity::class.java))
        }).start()
    }
}