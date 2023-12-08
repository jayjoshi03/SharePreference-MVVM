package com.example.demopractices.repository

interface SharedPreferencesManager {
    fun registerUser(name : String, email : String, password : String, gender : String, birthDay : String)
    fun isUpdateUser(name : String, email : String, gender : String, birthDay : String)
    fun updateLoginStatus(status : Boolean)
    fun logout(status : Boolean)
    fun getEmail() : String?
    fun getPassword() : String?
    fun getName() : String?
    fun getGender() : String?
    fun getBirthDay() : String?
    fun getLoginStatus() : Boolean
}