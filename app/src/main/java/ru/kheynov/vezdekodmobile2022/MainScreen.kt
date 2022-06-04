package ru.kheynov.vezdekodmobile2022

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.kheynov.feature_login.LoginMode.CREATE
import ru.kheynov.feature_login.LoginMode.VERIFY
import ru.kheynov.feature_login.LoginScreen
import ru.kheynov.vezdekodmobile2022.AppState.Login
import ru.kheynov.vezdekodmobile2022.AppState.Stories

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
            Toast.makeText(context, "Успешно", Toast.LENGTH_SHORT).show()
        }
        Login(VERIFY) -> {
            Toast.makeText(context, "Введите ваш пароль", Toast.LENGTH_SHORT).show()
            LoginScreen(onResult = { pin ->
                val res = viewModel.verifyPassword(pin)
                if (!res) Toast.makeText(context, "Неверный пароль", Toast.LENGTH_SHORT)
                    .show()
                return@LoginScreen res
            })
            Toast.makeText(context, "Успешно", Toast.LENGTH_SHORT).show()
        }
        Stories -> {
            Surface(modifier = Modifier.fillMaxSize(), color = Color.White) {
                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text(text = "Здесь будут историии",
                        fontSize = 40.sp,
                        textAlign = TextAlign.Center)
                }
            }
        }
        else -> {}
    }

}