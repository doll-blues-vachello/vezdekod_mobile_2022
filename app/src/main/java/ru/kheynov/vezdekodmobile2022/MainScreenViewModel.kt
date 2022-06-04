package ru.kheynov.vezdekodmobile2022

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import ru.kheynov.feature_login.LoginMode.CREATE
import ru.kheynov.feature_login.LoginMode.VERIFY
import ru.kheynov.vezdekodmobile2022.AppState.Login
import ru.kheynov.vezdekodmobile2022.AppState.Stories
import ru.kheynov.vezdekodmobile2022.data.PinCodeStorage

class MainScreenViewModel(application: Application) : AndroidViewModel(application) {
    private val _state = MutableLiveData<AppState>(Login(CREATE))
    val state: LiveData<AppState>
        get() = _state

    private val _isVerified = MutableLiveData(false)
    val isVerified: Boolean
        get() = _isVerified.value ?: false

    private val pinCodeStorage = PinCodeStorage(application.applicationContext.applicationContext)

    init {
        if (!isVerified)
            if (isPinExists()) {
                _state.value = Login(VERIFY)
                _isVerified.value = false
            } else {
                _state.value = Login(CREATE)
                _isVerified.value = false
            }
    }

    private fun isPinExists() = pinCodeStorage.isPinExists()

    fun verifyPassword(password: String): Boolean {
        if (password == pinCodeStorage.getPin()){
            _state.value = Stories
            return true
        }else{
            _state.value = Login(VERIFY)
            return false
        }
    }

    fun savePin(pin: String) {
        pinCodeStorage.save(pin)
        _state.value = Stories
    }
}