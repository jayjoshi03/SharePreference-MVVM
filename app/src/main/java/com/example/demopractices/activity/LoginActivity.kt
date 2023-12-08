package com.example.demopractices.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.demopractices.databinding.ActivityLoginBinding
import com.example.demopractices.utilities.Default
import com.example.demopractices.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLoginBinding
    private val viewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        manageClick()
    }

    private fun manageClick() {
        binding.apply {
            signupBtn.setOnClickListener {
                val intent = Intent(this@LoginActivity, RegisterScreen::class.java)
                intent.putExtra(Default.IS_UPDATE, false)
                startActivity(intent)
            }

            loginBtn.setOnClickListener {
                val email = editEmail.text.toString().trim()
                val password = editPassword.text.toString().trim()
                if(email.isNotEmpty() && password.isNotEmpty()){
                    login(email, password)
                }else Toast.makeText(this@LoginActivity, "One or Both filed empty", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun login(email : String, password : String) {
        val mEmail = viewModel.getEmail()
        val mPassword = viewModel.getPassword()

        if(mEmail!!.isNotEmpty() && mPassword!!.isNotEmpty()) {
            if(email == mEmail && password == mPassword) {
                viewModel.updateLoginStatus(true)
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else Toast.makeText(this, "Not Match Id and Password!!", Toast.LENGTH_SHORT).show()
        } else if(mEmail.isEmpty()) Toast.makeText(this, "Email is missing!!", Toast.LENGTH_SHORT).show()
        else Toast.makeText(this, "Password is missing!!", Toast.LENGTH_SHORT).show()
    }
}