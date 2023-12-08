package com.example.demopractices.repository

import android.content.Context
import javax.inject.Inject

class SharedPreferencesManagerImpl @Inject constructor(context : Context) : SharedPreferencesManager {
    private val FILE_NAME = "USER"
    private val KEY_NAME = "name"
    private val KEY_EMAIL = "email"
    private val KEY_PASS = "password"
    private val KEY_GENDER = "gender"
    private val KEY_BIRTHDAY = "birthDay"
    private val KEY_ISLOGIN = "login"
    private val sharedPreferences = context.getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
    private val editor = sharedPreferences.edit()

    override fun registerUser(name : String, email : String, password : String, gender : String, birthDay : String) {
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_PASS, password)
        editor.putString(KEY_GENDER, gender)
        editor.putString(KEY_BIRTHDAY, birthDay)
        editor.commit()
    }

    override fun isUpdateUser(name : String, email : String, gender : String, birthDay : String) {
        editor.putString(KEY_NAME, name)
        editor.putString(KEY_EMAIL, email)
        editor.putString(KEY_GENDER, gender)
        editor.putString(KEY_BIRTHDAY, birthDay)
        editor.commit()
    }

    override fun updateLoginStatus(status : Boolean) {
        editor.putBoolean(KEY_ISLOGIN, status)
        editor.commit()
    }

    override fun logout(status : Boolean) {
        editor.putBoolean(KEY_ISLOGIN, status)
        editor.commit()
    }

    override fun getEmail() : String? {
        return sharedPreferences.getString(KEY_EMAIL, null)
    }

    override fun getPassword() : String? {
        return sharedPreferences.getString(KEY_PASS, null)
    }

    override fun getName() : String? {
        return sharedPreferences.getString(KEY_NAME, null)
    }

    override fun getGender() : String? {
        return sharedPreferences.getString(KEY_GENDER, null)
    }

    override fun getBirthDay() : String? {
        return sharedPreferences.getString(KEY_BIRTHDAY, null)
    }

    override fun getLoginStatus() : Boolean {
        return sharedPreferences.getBoolean(KEY_ISLOGIN, false)
    }

}