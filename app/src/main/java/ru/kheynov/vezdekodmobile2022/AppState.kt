package ru.kheynov.vezdekodmobile2022

import ru.kheynov.feature_login.LoginMode

sealed interface AppState {
    data class Login(val loginMode: LoginMode) : AppState
    object Stories : AppState
}

