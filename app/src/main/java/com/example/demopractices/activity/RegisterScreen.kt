package com.example.demopractices.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.demopractices.databinding.ActivityResisterScreenBinding
import com.example.demopractices.utilities.Default
import com.example.demopractices.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegisterScreen : AppCompatActivity() {
    private lateinit var binding : ActivityResisterScreenBinding
    private val viewModel : UserViewModel by viewModels()
    private var isUpdate = false

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResisterScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)
        isUpdate = intent.getBooleanExtra(Default.IS_UPDATE, false)
        postInitViews()
        loadData()
        manageClick()
    }

    private fun postInitViews() {
        binding.apply {
            if(isUpdate) {
                signupBtn.visibility = View.GONE
                passwordLayout.visibility = View.GONE
                cPasswordLayout.visibility = View.GONE
            } else
                updateBtn.visibility = View.GONE
        }
    }

    private fun loadData() {
        binding.apply {
            if(isUpdate) {
                editName.setText(viewModel.getName())
                editEmail.setText(viewModel.getEmail())
                editBirthDay.setText(viewModel.getBirthDay())
                checkMale.isChecked = viewModel.getGender() == Default.MALE
                checkFemale.isChecked = viewModel.getGender() == Default.FEMALE
            }
        }
    }

    private fun manageClick() {
        binding.apply {
            signupBtn.setOnClickListener {
                registerUser()
            }

            updateBtn.setOnClickListener {
                updateUser()
                startActivity(Intent(this@RegisterScreen, MainActivity::class.java))
            }
        }
    }

    private fun updateUser() {
        binding.apply {
            val name = editName.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val birth = editBirthDay.text.toString().trim()
            val gender = if(checkMale.isChecked) Default.MALE else Default.FEMALE
            if(email.isNotEmpty()) {
                viewModel.isUpdateUser(name, email, gender, birth)
            }
        }
    }

    private fun registerUser() {
        binding.apply {
            val name = editName.text.toString().trim()
            val email = editEmail.text.toString().trim()
            val password = editPassword.text.toString().trim()
            val cPassword = editConfirmPassword.text.toString().trim()
            val birth = editBirthDay.text.toString().trim()
            val gender = if(checkMale.isChecked) Default.MALE else Default.FEMALE

            if(email.isNotEmpty() && cPassword.isNotEmpty()) {
                if(password == cPassword) {
                    viewModel.registerUser(name, email, cPassword, gender, birth)
                    startActivity(Intent(this@RegisterScreen, LoginActivity::class.java))
                } else Toast.makeText(this@RegisterScreen, "Password not match!!", Toast.LENGTH_SHORT).show()
            } else Toast.makeText(this@RegisterScreen, "email and Password empty!!", Toast.LENGTH_SHORT).show()
        }
    }

}