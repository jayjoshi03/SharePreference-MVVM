package com.example.demopractices.viewmodel

import androidx.lifecycle.ViewModel
import com.example.demopractices.repository.SharedPreferencesManager
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val sharedPreferencesManager : SharedPreferencesManager) : ViewModel() {

    fun registerUser(name : String, email : String, password : String, gender : String, birthDay : String) {
        sharedPreferencesManager.registerUser(name, email, password, gender, birthDay)
    }

    fun isUpdateUser(name : String, email : String, gender : String, birthDay : String) {
        sharedPreferencesManager.isUpdateUser(name, email, gender, birthDay)
    }

    fun updateLoginStatus(status : Boolean) {
        sharedPreferencesManager.updateLoginStatus(status)
    }

    fun logout(status : Boolean) {
        sharedPreferencesManager.logout(status)
    }

    fun getEmail() : String? {
        return sharedPreferencesManager.getEmail()
    }

    fun getPassword() : String? {
        return sharedPreferencesManager.getPassword()
    }

    fun getName() : String? {
        return sharedPreferencesManager.getName()
    }

    fun getGender() : String? {
        return sharedPreferencesManager.getGender()
    }

    fun getBirthDay() : String? {
        return sharedPreferencesManager.getBirthDay()
    }

    fun getLoginStatus() : Boolean {
        return sharedPreferencesManager.getLoginStatus()
    }
}