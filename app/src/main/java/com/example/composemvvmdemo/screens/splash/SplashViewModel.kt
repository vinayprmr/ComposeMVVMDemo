package com.example.composemvvmdemo.screens.splash

import android.content.SharedPreferences
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


class SplashViewModel  : ViewModel() {
    val isLoggedIn: Boolean = false

    lateinit var pref: SharedPreferences


}