package ru.kheynov.feature_login

import android.app.Application
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

sealed interface LoginState {
    object Done : LoginState
    object InProgress : LoginState
}

class LoginScreenViewModel(application: Application) : AndroidViewModel(application) {
    private val _passwordProgress = mutableStateOf(0)

    private val _state = MutableLiveData<LoginState>(LoginState.InProgress)
    val state: LiveData<LoginState>
        get() = _state

    private val _password = mutableListOf<Int>()
    val password: String
        get() = passwordToString(_password)

    val passwordProgress: Int
        get() = _passwordProgress.value

    private fun increaseProgress() {
        _passwordProgress.value = _passwordProgress.value.inc()
    }

    private fun decreaseProgress() {
        _passwordProgress.value = _passwordProgress.value.dec()
    }

    fun onPadClick(padIndex: Int) {
        if (padIndex < 0) {
            when (padIndex) {
                -1 -> return
                -2 -> {
                    if (passwordProgress == 0) return
                    decreaseProgress()
                    _password.removeLast()
                }
            }
            return
        }
        increaseProgress()
        _password.add(padIndex)
        if (_password.size == 4) {
            setState(LoginState.Done)
        } else {
            setState(LoginState.InProgress)
        }

    }

    private fun setState(state: LoginState) {
        if (_state != state) _state.value = state
    }

    private fun passwordToString(password: List<Int>): String {
        val pin = StringBuilder()
        password.forEach {
            pin.append(it.toString())
        }
        return pin.toString()
    }
}