package ru.kheynov.feature_login

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import ru.kheynov.feature_login.pin_pad.PinPad
import ru.kheynov.feature_login.pin_progress.PinProgress
import ru.kheynov.feature_login.theme.LoginScreenTheme

private const val TAG = "LoginScreen"

@Composable
fun LoginScreen(
    onResult: (String) -> Boolean = { true },
    viewModel: LoginScreenViewModel = viewModel(),
) {
    val passwordProgressState: Int = viewModel.passwordProgress

    val loginState by viewModel.state.observeAsState()

    if (loginState == LoginState.Done) {
        if (!onResult(viewModel.password)) viewModel.clear()
        Log.i(TAG, "Entering done")
    }

    LoginScreenTheme {
        Surface(modifier = Modifier.fillMaxSize(),
            color = MaterialTheme.colors.background) {
        }
        Column {
            Spacer(modifier = Modifier.height(100.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Image(
                    imageVector = ImageVector.vectorResource(R.drawable.ic_mail_logo),
                    contentDescription = "mail_ru_logo",
                )
            }
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Text(text = "?????????????? ??????-??????", fontSize = 20.sp,
                    color = Color.White)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                PinProgress(modifier = Modifier.width(127.dp), state = passwordProgressState)
            }
            Spacer(modifier = Modifier.height(52.dp))
            Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center) {
                PinPad(
                    modifier = Modifier.padding(horizontal = 54.dp),
                    onClick = { idx ->
                        viewModel.onPadClick(idx)
                        Log.d("LoginScreen", "Password is now is: ${viewModel.password}")
//                            Log.d("LoginScreen", "Button $idx pressed ")
                    })
            }
        }
    }
}

