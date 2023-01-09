package com.example.composemvvmdemo.screens.login

import android.content.SharedPreferences
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composemvvmdemo.utils.EmailState
import com.example.composemvvmdemo.utils.PasswordState
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch


class LogInViewModel : ViewModel() {

    lateinit var pref: SharedPreferences

    private val _emailState = EmailState()
    val emailState: EmailState = _emailState

    private val _passwordState = PasswordState()
    val passwordState: PasswordState = _passwordState

    fun onEmailChanged(email: String) {
        _emailState.text = email
    }

    fun onPasswordChanged(password: String) {
        _passwordState.text = password
    }

    private val auth: FirebaseAuth = Firebase.auth

    private val _loading = MutableLiveData(false)
    val loading: LiveData<Boolean> = _loading

    fun signInWithEmailAndPassword(home:()->Unit) = viewModelScope.launch {
        try {
            auth.signInWithEmailAndPassword(emailState.text, passwordState.text)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d("TAGMainnn", "signInWithEmailAndPassword: ${task.result}")
                        home()
                    } else {
                        Log.d("TAGMain", "signInWithEmailAndPassword: ${task.result}")
                    }

                }
        } catch (ex: Exception) {

        }
    }
}