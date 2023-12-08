package com.example.demopractices.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.demopractices.databinding.ActivityMainBinding
import com.example.demopractices.utilities.Default
import com.example.demopractices.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val viewModel : UserViewModel by viewModels()

    override fun onCreate(savedInstanceState : Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadData()
        manageClick()
    }

    private fun loadData() {
        binding.apply {
            textName.text = viewModel.getName()
            textEmail.text = viewModel.getEmail()
            textBirthDay.text = viewModel.getBirthDay()
            textGender.text = viewModel.getGender()
        }
    }

    private fun manageClick() {
        binding.apply {
            //Logout Button Click
            logoutBtn.setOnClickListener {
                viewModel.logout(false)
                startActivity(Intent(this@MainActivity, LoginActivity::class.java))
            }

            //Update Button Click
            updateBtn.setOnClickListener {
                val intent = Intent(this@MainActivity, RegisterScreen::class.java)
                intent.putExtra(Default.IS_UPDATE, true)
                startActivity(intent)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressedDispatcher.onBackPressed()
        return super.onSupportNavigateUp()
    }

}