package ru.kheynov.vezdekodmobile2022

import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.kheynov.feature_login.LoginMode.CREATE
import ru.kheynov.feature_login.LoginMode.VERIFY
import ru.kheynov.feature_login.LoginScreen
import ru.kheynov.feature_stories.StoriesScreen
import ru.kheynov.vezdekodmobile2022.AppState.Login
import ru.kheynov.vezdekodmobile2022.AppState.Stories

private const val TAG = "MainScreen"

@Composable
fun MainScreen(
    viewModel: MainScreenViewModel = viewModel(),
) {
    val context = LocalContext.current
    val state = viewModel.state.observeAsState()
    when (state.value) {
        Login(CREATE) -> {
            Toast.makeText(context, "Создайте новый пароль", Toast.LENGTH_SHORT).show()
            LoginScreen(onResult = { pin ->
                viewModel.savePin(pin)
                return@LoginScreen true
            })
        }
        Login(VERIFY) -> {
            Toast.makeText(context, "Введите ваш пароль", Toast.LENGTH_SHORT).show()
            LoginScreen(onResult = { pin ->
                val res = viewModel.verifyPassword(pin)
                if (!res) Toast.makeText(context, "Неверный пароль", Toast.LENGTH_SHORT)
                    .show()
                return@LoginScreen res
            })
        }
        Stories -> {
            StoriesScreen()
        }
        else -> {
            Log.i(TAG, "Something went wrong")}
    }

}