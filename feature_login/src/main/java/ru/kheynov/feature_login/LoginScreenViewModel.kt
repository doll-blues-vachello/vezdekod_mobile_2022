package ru.kheynov.feature_login

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoginScreenViewModel : ViewModel() {
    private val _passwordProgress = mutableStateOf(0)

    private val _password = mutableListOf<Int>()
    val password: List<Int>
        get() = _password

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
        if (passwordProgress >= 4) {
            _passwordProgress.value = 0
            _password.clear()
        }
        increaseProgress()
        _password.add(padIndex)
    }
}