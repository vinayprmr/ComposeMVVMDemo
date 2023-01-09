package com.example.composemvvmdemo.screens.signup

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.composemvvmdemo.utils.EmailState
import com.example.composemvvmdemo.utils.PasswordState
import com.example.composemvvmdemo.utils.UsernameState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase


class SignUpViewModel : ViewModel() {

    lateinit var pref: SharedPreferences

    private val auth: FirebaseAuth = Firebase.auth

    private val _usernameState = UsernameState()
    val usernameState = _usernameState

    private val _emailState = EmailState()
    val emailState: EmailState = _emailState

    private val _passwordState = PasswordState()
    val passwordState: PasswordState = _passwordState

    private val _confirmPasswordState = PasswordState()
    val confirmPasswordState: PasswordState = _confirmPasswordState


    fun onEmailChange(email: String) {
        _emailState.text = email
    }

    fun onPasswordChange(password: String) {
        _passwordState.text = password
    }

    fun onConfirmPasswordChange(password: String) {
        _confirmPasswordState.text = password
    }

    fun onUsernameChange(username: String) {
        _usernameState.text = username
    }

    fun createUserWithEmailAndPassword(home: () -> Unit) {
        auth.createUserWithEmailAndPassword(emailState.text, passwordState.text)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    home()
                } else {
                    Log.d("TAGGG", "createUserWithEmailAndPassword: ${task.result}")
                }
            }
    }
}